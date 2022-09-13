package com.qa.student.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Student already exists with this name")
public class StudentAlreadyExistsException extends Exception{

}
