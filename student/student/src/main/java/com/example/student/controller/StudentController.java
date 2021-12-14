package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@PostMapping("/addStudents")
	public List<Student> addStudents(@RequestBody List<Student> students){
		return studentService.createStudents(students);
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}
	@GetMapping("/students")
	public List<Student> getAllStudent(){
		return studentService.getStudents();
	}
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteStudentById(id);
	}
}
