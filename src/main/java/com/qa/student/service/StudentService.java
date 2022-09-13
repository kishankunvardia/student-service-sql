package com.qa.student.service;

import java.util.List;
import com.qa.student.exceptions.StudentAlreadyExistsException;
import com.qa.student.exceptions.StudentNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.student.entity.Student;
import com.qa.student.exceptions.StudentAlreadyExistsException;
import com.qa.student.repository.StudentRepo;
import java.util.List;
import java.util.Optional;
@Service
public class StudentService implements IStudentService{
	
	
	@Autowired
	StudentRepo sRepository;

	@Override
	public Student saveStudent(Student student) throws StudentAlreadyExistsException {
		// TODO Auto-generated method stub
		Optional<Student> findByName = sRepository.findByFirstName(student.getFirstName());
		if(findByName.isPresent())
				throw new StudentAlreadyExistsException();
		else
			return sRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return sRepository.findAll();
	}

	@Override
	public Student getStudentById(long id) throws StudentNotFoundException {
		Optional <Student> findById = sRepository.findById(id);
		if(!findById.isPresent())
			throw new StudentNotFoundException();
		else
			return findById.get();
		
	}

	@Override
	public Student updateStudent(Student student) throws StudentNotFoundException {
		Optional<Student> findById = sRepository.findById(student.getId());
		
		if(!findById.isPresent())
			throw new StudentNotFoundException();
		else {
				Student existingStudent = findById.get(); 
				existingStudent.setLastName(student.getLastName());			
			return sRepository.saveAndFlush(existingStudent);
		}
	}

	@Override
	public boolean deleteStudent(long id) throws StudentNotFoundException {
		boolean status = false;
		Optional<Student> findById = sRepository.findById(id);
		if(!findById.isPresent())
			throw new StudentNotFoundException();
		else {
			sRepository.delete(findById.get());
			status = true;
			}
		
		return status;
	}

}
