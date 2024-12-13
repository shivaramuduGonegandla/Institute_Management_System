package com.institute.controller;

import com.institute.service.CourseService;
import com.institute.service.InstructorService;
import com.institute.service.StudentService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final StudentService studentService;
    private final CourseService courseService;
    private final InstructorService instructorService;

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("studentCount", studentService.getStudentCount());
        model.addAttribute("courseCount", courseService.getCourseCount());
        model.addAttribute("instructorCount", instructorService.getInstructorCount());
        model.addAttribute("recentStudents", studentService.getRecentStudents(Pageable.ofSize(5)));
        model.addAttribute("recentCourses", courseService.getRecentCourses(Pageable.ofSize(5)));
        return "index";
    }

	public DashboardController(StudentService studentService, CourseService courseService,
			InstructorService instructorService) {
		super();
		this.studentService = studentService;
		this.courseService = courseService;
		this.instructorService = instructorService;
	}
    
    
}