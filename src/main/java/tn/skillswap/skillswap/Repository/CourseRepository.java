package tn.skillswap.skillswap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.skillswap.skillswap.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
