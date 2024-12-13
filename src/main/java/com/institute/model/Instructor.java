package com.institute.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "instructors")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @Email(message = "Please provide a valid email address")
    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
}