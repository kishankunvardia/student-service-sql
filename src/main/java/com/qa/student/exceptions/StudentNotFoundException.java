package com.qa.student.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Student doesn't exists with this id")
public class StudentNotFoundException extends Exception{

}
