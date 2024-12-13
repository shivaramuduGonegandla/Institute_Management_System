package com.institute.controller;

import com.institute.service.CourseService; // Import CourseService
import org.springframework.beans.factory.annotation.Autowired; // Import @Autowired
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
public class CourseController {
  
    @Autowired
    private CourseService courseService; // Inject the CourseService
    
    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses()); // Use injected service
        return "courses/list"; // Corresponding view to be rendered
    }
    
}
