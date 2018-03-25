package com.test.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUD_ID")
	private int studId;

	@Column(name = "NAME")
	@Size(max = 20, min = 3, message = "{student.name.invalid}")
	@NotEmpty(message = "Please Enter your name")
	private String name;

	@Column(name = "FNAME")
	@Size(max = 20, min = 3, message = "{student.fname.invalid}")
	@NotEmpty(message = "Please Enter your Fathersname")
	private String fName;

	@Column(name = "DOB")
	@Size(max = 20, min = 3, message = "{student.dob.invalid}")
	@NotEmpty(message = "Please Enter your Date Of Birth")
	private String dob;

	@Column(name = "COURSE")
	@Size(max = 20, min = 3, message = "{student.course.invalid}")
	@NotEmpty(message = "Please Enter your course")
	private String course;

	@Column(name = "ADDR")
	@Size(max = 20, min = 3, message = "{student.addr.invalid}")
	@NotEmpty(message = "Please Enter your Address")
	private String addr;

	@Column(name = "EMAIL", unique = true)
	@Email(message = "{student.email.invalid}")
	@NotEmpty(message = "Please Enter your email")
	private String email;

	@Column(name = "MOB")
	@Size(max = 20, min = 3, message = "{student.mob.invalid}")
	@NotEmpty(message = "Please Enter your Mobile  No")
	private String mob;

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}
}
