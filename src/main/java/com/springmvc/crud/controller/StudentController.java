package com.springmvc.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.crud.entity.Student;
import com.springmvc.crud.repository.StudentRepository;

import lombok.Lombok;

@RestController
@RequestMapping("/home")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	

	@GetMapping
	public List<Student> getAll(Student student){
		System.out.println("Getting all the student : ");
		return studentRepository.findAll();
		}
	
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		try {
			Student student = studentRepository.findById(id).get();
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	
}
