package com.krishnaedu.edu_content.controller;

import com.krishnaedu.edu_content.model.Course;
import com.krishnaedu.edu_content.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/course")
    public ResponseEntity<?> getCourse(){
        List<Course> courses = courseService.getCourse();
        return ResponseEntity.ok(courses);
    }
}
