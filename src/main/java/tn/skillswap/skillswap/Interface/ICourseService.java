package tn.skillswap.skillswap.Interface;

import tn.skillswap.skillswap.Entity.Course;

import java.util.List;

public interface ICourseService {
    List<Course> getAllCourses();
    Course getCourseById(long idCourse);
}
