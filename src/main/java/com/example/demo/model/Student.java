package com.example.demo.model;


import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="student")
public class Student {
	 
	@Id
    private long ID;
	
	
	@Pattern(regexp="^[A-Za-z]*$")
	@NotBlank(message = "Please provide a first name")
	private String fname;//first name
	
	@Pattern(regexp="^[A-Za-z]*$")
	private String lname;//last name
	
	
	
	private String dob;
	
	
	private String age;
	
	
	@NotBlank(message = "Please provide a college")
	
	private String college;
	
	@Pattern(regexp="^[A-Za-z]*$")
	@NotBlank
	private String branch;
	
	@NotBlank (message = "Please provide a valid email id")
	@Email
	private String email;
	
	
   @Min(1)
	private long contact;//contact number
	
	public Student(long iD, long contact, String fname, String lname, String dob, String age, String college,
			String branch, String email) 
	{
		super();
		ID = iD;
		this.contact = contact;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.age = age;
		this.college = college;
		this.branch = branch;
		this.email = email;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [ID=" + ID + ", contact=" + contact + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob
				+ ", age=" + age + ", college=" + college + ", branch=" + branch + ", email=" + email + "]";
	}
	
	

}
