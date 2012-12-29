package com.examscam.mappings;

import java.util.List;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 353 created LeftManyStudent class
// Page: 356 added ManyToMany annotation

@Entity
public class LeftManyStudent {
	long id;
	String studentName;
	List<RightManyCourse> courses = new Vector();

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToMany
	@JoinTable(name = "join_table", joinColumns = {@JoinColumn(name = "lmstudent_id")}, inverseJoinColumns = {@JoinColumn(name = "rmcourse_id")})
	public List<RightManyCourse> getCourses() {
		return courses;
	}

	public void setCourses(List<RightManyCourse> righties) {
		this.courses = righties;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String s) {
		studentName = s;
	}
}
