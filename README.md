# Spring Boot Demo Project

Un petit projet Spring Boot Maven avec 2 services, 2 entités et Lombok.

## Structure du projet

```
springboot-demo/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── demo/
│   │   │               ├── DemoApplication.java
│   │   │               ├── entity/
│   │   │               │   ├── User.java
│   │   │               │   └── Product.java
│   │   │               ├── repository/
│   │   │               │   ├── UserRepository.java
│   │   │               │   └── ProductRepository.java
│   │   │               ├── service/
│   │   │               │   ├── UserService.java
│   │   │               │   └── ProductService.java
│   │   │               └── controller/
│   │   │                   ├── UserController.java
│   │   │                   └── ProductController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── demo/
│                       └── service/
│                           ├── UserServiceTest.java
│                           └── ProductServiceTest.java
└── README.md
```

## Entités

### User
- id (Long)
- name (String)
- email (String, unique)
- age (Integer)

### Product
- id (Long)
- name (String)
- description (String)
- price (Double)
- stock (Integer)

## Services

1. **UserService** : Gestion des utilisateurs (CRUD)
2. **ProductService** : Gestion des produits (CRUD)

## Technologies utilisées

- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database (en mémoire)
- Lombok (pour réduire le code boilerplate)
- JaCoCo (pour la couverture de code)
- Maven

## Lancement du projet

```bash
# Compiler le projet
mvn clean install

# Lancer l'application
mvn spring-boot:run
```

L'application démarre sur `http://localhost:8080`

## Génération du rapport JaCoCo

```bash
# Exécuter les tests et générer le rapport de couverture
mvn clean test

# Le rapport HTML sera généré dans : target/site/jacoco/index.html
```

Ouvrez `target/site/jacoco/index.html` dans votre navigateur pour voir le rapport de couverture de code.

## Endpoints API

### Users
- `GET /api/users` - Liste tous les utilisateurs
- `GET /api/users/{id}` - Récupère un utilisateur par ID
- `POST /api/users` - Crée un nouvel utilisateur
- `PUT /api/users/{id}` - Met à jour un utilisateur
- `DELETE /api/users/{id}` - Supprime un utilisateur

### Products
- `GET /api/products` - Liste tous les produits
- `GET /api/products/{id}` - Récupère un produit par ID
- `POST /api/products` - Crée un nouveau produit
- `PUT /api/products/{id}` - Met à jour un produit
- `DELETE /api/products/{id}` - Supprime un produit

## Console H2

Accédez à la console H2 sur : `http://localhost:8080/h2-console`

- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (vide)

## Exemple de requête

### Créer un utilisateur
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","email":"john@example.com","age":30}'
```

### Créer un produit
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Laptop","description":"Gaming laptop","price":1200.50,"stock":10}'
```
