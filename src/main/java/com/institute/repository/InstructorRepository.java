package com.institute.repository;

import com.institute.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    
	List<Instructor> findByNameContainingIgnoreCase(String name);
    boolean existsByEmail(String email);
}