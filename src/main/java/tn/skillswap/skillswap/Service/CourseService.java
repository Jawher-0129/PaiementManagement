package tn.skillswap.skillswap.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.skillswap.skillswap.Entity.Course;
import tn.skillswap.skillswap.Interface.ICourseService;
import tn.skillswap.skillswap.Repository.CourseRepository;

import java.util.List;
@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(long idCourse) {
        return courseRepository.findById(idCourse).get();
    }
}
