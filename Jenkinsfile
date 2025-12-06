pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'jawhertb/paiementimage'
        DOCKER_TAG = 'latest'
        REPORT_DIR = 'reports'
    }

    stages {

        stage('Cloning project from GitHub') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/Jawher-0129/PaiementManagement.git'
            }
        }

        stage('Security: Secrets Scan (Gitleaks)') {
            steps {
                echo "--- Scan des secrets avec Gitleaks ---"
                sh """
                    mkdir -p ${REPORT_DIR}
                    gitleaks detect --source . -v --report-path ${REPORT_DIR}/gitleaks-report.html || true
                """
            }
        }

        stage('CLEAN AND BUILD') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Building Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
            }
        }

        stage('Security: Docker Image Scan (Trivy)') {
            steps {
                echo "--- Scan de l'image Docker avec Trivy ---"
                sh """
                    mkdir -p ${REPORT_DIR}
                    trivy image --exit-code 0 --severity CRITICAL,HIGH \
                    --format template --template "@contrib/html.tpl" \
                    -o ${REPORT_DIR}/trivy-report.html ${DOCKER_IMAGE}:${DOCKER_TAG} || true
                """
            }
        }

        stage('Push to DockerHub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-credentials',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                    sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
            }
        }

        stage('SONARQUBE Analysis') {
            steps {
                withCredentials([string(credentialsId: 'sonar-token-credentials', variable: 'SONAR_TOKEN')]) {
                    sh """
                        mvn clean verify sonar:sonar -Dmaven.test.skip=true \
                            -Dsonar.projectKey=PaiementProject \
                            -Dsonar.host.url=http://localhost:9000 \
                            -Dsonar.login=${SONAR_TOKEN}
                    """
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh '''
                    kubectl apply -f k8s/mysql-deployment.yaml
                    kubectl apply -f k8s/backend-deployment.yaml
                '''
            }
        }

        stage('Security: DAST Scan (OWASP ZAP)') {
    steps {
        echo "--- Scan dynamique OWASP ZAP ---"
        sh """
            mkdir -p ${REPORT_DIR}
            docker run --rm -v \$(pwd)/${REPORT_DIR}:/zap/wrk:rw -t zaproxy/zap-stable:latest \
                zap-baseline.py -t http://host.docker.internal:8080 -f html -o /zap/wrk/zap-report.html || true
        """
    }
}


    }

    post {
        always {
            publishHTML([
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'reports',
                reportFiles: 'gitleaks-report.html,trivy-report.html,zap-report.html',
                reportName: 'Security Reports'
            ])
        }
        success {
            echo "pipeline completed successfully."
        }
        failure {
            echo "pipeline failed."
        }
    }
}
