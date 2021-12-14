package com.example.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.entity.Student;

public interface StudentRepositry extends JpaRepository<Student, Integer> {

}






