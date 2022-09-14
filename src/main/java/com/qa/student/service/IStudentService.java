package com.qa.student.service;

import java.util.List;

import com.qa.student.dto.StudentDto;
import com.qa.student.entity.Student;
import com.qa.student.exceptions.StudentAlreadyExistsException;
import com.qa.student.exceptions.StudentNotFoundException;

public interface IStudentService {
	
	//CRUD operations
		public Student saveStudent(Student student) throws StudentAlreadyExistsException; 
		public List<Student> getAllStudents();
		public Student getStudentById(long id) throws StudentNotFoundException; 
		public Student updateStudent(Student student) throws StudentNotFoundException;
		public boolean deleteStudent(long id) throws StudentNotFoundException;
		List<StudentDto> getAllStudentDtos();

}
