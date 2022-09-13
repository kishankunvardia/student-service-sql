package com.qa.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "s_id")
    private long id;

	@NotNull
	@Size(min = 2, max = 20, message = "first name must be between 2 and 20 characters only")
	@Pattern(regexp = "^[A-Za-z0-9]*", message = "invalid first name, must contain only alphanumeric")
    @Column (name = "s_firstName")
    private String firstName;

	@NotNull
	@Size(min = 2, max = 20, message = "last name must be between 2 and 20 characters only")
	@Pattern(regexp = "^[A-Za-z0-9]*", message = "invalid last name, must contain only alphanumeric")
    @Column (name = "s_lastName")
    private String lastName;
    
	@NotNull
	@Size(min = 2, max = 20, message = "town must be between 2 and 20 characters only")
	@Pattern(regexp = "^[A-Za-z0-9]*", message = "invalid town, must contain only alphanumeric")
    @Column (name = "s_town")
    private String town;
	
	@NotNull
	@Size(min = 4)	
    @Column (name = "s_dob")
    private String dob;
    
    

}
