package com.qa.student.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qa.student.entity.Student;
import com.qa.student.exceptions.StudentAlreadyExistsException;
import com.qa.student.exceptions.StudentNotFoundException;
import com.qa.student.service.StudentService;

@RestController
@RequestMapping("api/v1/student-service")
public class StudentController {
	
	@Autowired
	StudentService sService;
	
	/*
	 * It is the responsible for sending the response to the client converting java
	 * objects to json by default along with the status code
	 * 
	 * 
	 */
	ResponseEntity<?> responseEntity;
	
	@PostMapping("/student")
	public ResponseEntity<?> saveStudent(@Valid @RequestBody Student student) throws StudentAlreadyExistsException{
		Student createdStudent;
		try {
			createdStudent = this.sService.saveStudent(student);
		} catch (StudentAlreadyExistsException e) {
			throw e;
		}
		responseEntity = new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/student")
	public ResponseEntity<?> getAllStudents(){
		return new ResponseEntity<>(this.sService.getAllStudents(), HttpStatus.OK);
	}

	
	
	
	@GetMapping("/student/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") long id) throws StudentNotFoundException {
		Student student;
		try {
			student = this.sService.getStudentById(id);
		} catch (StudentNotFoundException e) {
			throw e;
		}
		responseEntity = new ResponseEntity<>(student, HttpStatus.OK);
		return responseEntity;
		//employee/3 -> Path Variable
		
	}
	
	@DeleteMapping("/student")
	public ResponseEntity<?> deleteStudentById(@RequestParam("id") long id) throws StudentNotFoundException {
		boolean status;
		try {
			status = this.sService.deleteStudent(id);
			responseEntity = new ResponseEntity<>("Student Deleted Successfully !!!", HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			throw e;
		}		
		return responseEntity;
		//employee?id=3 -> RequestParameter
	}
	
	@PutMapping("/student")
	public ResponseEntity<?> updateStudent(@RequestBody Student student) throws StudentNotFoundException{
		try {
			responseEntity = new ResponseEntity<>(sService.updateStudent(student),HttpStatus.OK);
		} catch(StudentNotFoundException e) {
			throw e;
		}		
		return responseEntity;
	}
}

