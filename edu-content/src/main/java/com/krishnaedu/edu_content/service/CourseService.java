package com.krishnaedu.edu_content.service;

import com.krishnaedu.edu_content.model.Course;
import com.krishnaedu.edu_content.model.Technology;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class CourseService {
    public List<Course> getCourse(){
        List<Course> courses = new ArrayList<>();
        List<Technology> technologies = new ArrayList<>();

        // Preparing Technologies
        Technology technology = new Technology();
        technology.setId(UUID.randomUUID().toString());
        technology.setName("Java");
        technologies.add(technology);

        // Preparing course
        Course course = new Course();
        course.setId(UUID.randomUUID().toString());
        course.setName("Java Full Stack Course");
        course.setTechnologies(technologies);
        courses.add(course);

        return courses;
    }
}
