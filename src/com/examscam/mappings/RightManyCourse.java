package com.examscam.mappings;

import java.util.List;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.Session;

import com.examscam.HibernateUtil;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 353 created RightManyStudent class
// Page: 356 added ManyToMany annotation
// Page: 361 added static void main method

@Entity
public class RightManyCourse {
	long id;
	String courseCode;
	List<LeftManyStudent> students = new Vector();

	@ManyToMany
	@JoinTable(name = "join_table", joinColumns = {@JoinColumn(name = "rmcourse_id")}, inverseJoinColumns = {@JoinColumn(name = "lmstudent_id")})
	public List<LeftManyStudent> getStudents() {
		return students;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public void setStudents(List<LeftManyStudent> lefties) {
		this.students = lefties;
	}

	public static void main(String[] args) {
		HibernateUtil.recreateDatabase();

		LeftManyStudent student01 = new LeftManyStudent();
		student01.setStudentName("Jim Jump");

		LeftManyStudent student02 = new LeftManyStudent();
		student02.setStudentName("Julie Camp");

		LeftManyStudent student03 = new LeftManyStudent();
		student03.setStudentName("Cam Johnson");

		LeftManyStudent student04 = new LeftManyStudent();
		student04.setStudentName("Marcus McKenzie");

		RightManyCourse java101 = new RightManyCourse();
		java101.setCourseCode("Java-101");

		RightManyCourse cplus101 = new RightManyCourse();
		cplus101.setCourseCode("C++ - 101");

		RightManyCourse math101 = new RightManyCourse();
		math101.setCourseCode("Math - 101");

		java101.getStudents().add(student01);
		java101.getStudents().add(student02);
		java101.getStudents().add(student03);

		cplus101.getStudents().add(student02);
		cplus101.getStudents().add(student03);

		math101.getStudents().add(student04);

		Session session = HibernateUtil.beginTransaction();
		session.save(student01);
		session.save(student02);
		session.save(student03);
		session.save(student04);
		session.save(java101);
		session.save(cplus101);
		session.save(math101);
		HibernateUtil.commitTransaction();
	}
}
