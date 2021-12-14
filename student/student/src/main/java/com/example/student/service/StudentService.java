package com.example.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.dao.StudentRepositry;
import com.example.student.entity.Student;

@Service
public class StudentService {
	@Autowired
	private StudentRepositry studentRepositry;
	
	public Student createStudent(Student student) {
		return studentRepositry.save(student);
	}
	public List<Student> createStudents(List<Student> students) {
		return studentRepositry.saveAll(students);
	}
	public Student getStudentById(int id) {
		return studentRepositry.findById(id).orElse(null);
	}
	public List<Student> getStudents(){
		return studentRepositry.findAll();
	}
	public Student updateStudent(Student student) {
			Student oldStudent = null;
			Optional<Student> optionalstudent = studentRepositry.findById(student.getId());
			if(optionalstudent.isPresent()) {
				oldStudent=optionalstudent.get();
				oldStudent.setName(student.getName());
				oldStudent.setAddress(student.getAddress());
				studentRepositry.save(oldStudent);
				
			}else {
				return new Student();
			}
			return oldStudent;
	}
	public String deleteStudentById(int id) {
		studentRepositry.deleteById(id);
		return "User successfully deleted";
	}
	
}
