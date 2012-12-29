package com.examscam.hib.exam;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 332 ExamDetail class

@Entity
@Table(name = "exam_detail", schema = "examscam")
public class ExamDetail {
	private int id;
	private String fullName;
	private int numberOfQuestions;
	private int passingPercentage;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	private Exam exam;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "detail")
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@Basic
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Basic
	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	@Basic
	public int getPassingPercentage() {
		return passingPercentage;
	}

	public void setPassingPercentage(int passingPercentage) {
		this.passingPercentage = passingPercentage;
	}
}
