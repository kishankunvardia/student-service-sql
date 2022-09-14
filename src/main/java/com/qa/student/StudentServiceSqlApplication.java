package com.qa.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class StudentServiceSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceSqlApplication.class, args);
	}

}
