package com.institute.service;

import com.institute.model.Instructor;
import com.institute.repository.InstructorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;

    public long getInstructorCount() {
        return instructorRepository.count();
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Page<Instructor> getAllInstructors(Pageable pageable) {
        return instructorRepository.findAll(pageable);
    }

    public List<Instructor> searchInstructors(String name) {
        return instructorRepository.findByNameContainingIgnoreCase(name);
    }

    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Instructor not found"));
    }

    public boolean isEmailTaken(String email) {
        return instructorRepository.existsByEmail(email);
    }

    public Instructor saveInstructor(Instructor instructor) {
        if (instructor.getId() == null && isEmailTaken(instructor.getEmail())) {
            throw new IllegalArgumentException("Email is already in use");
        }
        return instructorRepository.save(instructor);
    }

    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }
    
    public List<Instructor> getRecentInstructors(Pageable pageable) {
        return instructorRepository.findAll(pageable).getContent();
    }
    
    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

   
}
