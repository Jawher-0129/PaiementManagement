package tn.skillswap.skillswap.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.skillswap.skillswap.Entity.CompteBancaire;
import tn.skillswap.skillswap.Entity.Course;
import tn.skillswap.skillswap.Interface.ICourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @GetMapping("/getcourses")
    public List<Course> getAllcourses() {
        System.out.println(courseService.getAllCourses());
        return courseService.getAllCourses();
    }

    @GetMapping("/getcourses/{id_Course}")
    public Course getcourseById(@PathVariable long id_Course) {
        return courseService.getCourseById(id_Course);
    }

}
