package com.examscam.hib.exam;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;

import com.examscam.HibernateUtil;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 331 complete Exam class
// Page: 333 added static void main method

@Entity
@Table(name = "exam", schema = "examscam")
public class Exam {
	private int id;
	private String shortName;
	private ExamDetail detail;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	// Notice that the Exam maintains an instance of the ExamDetail class

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "detail_id")
	public ExamDetail getDetail() {
		return detail;
	}

	public void setDetail(ExamDetail detail) {
		this.detail = detail;
	}

	public static void main(String[] args) {
		HibernateUtil.recreateDatabase();
		Exam exam = new Exam();
		exam.setShortName("SCJA");
		ExamDetail detail = new ExamDetail();
		detail.setFullName("Sun Certified Java Associate");
		detail.setPassingPercentage(62);
		detail.setNumberOfQuestions(55);
		exam.setDetail(detail);
		Session session = HibernateUtil.beginTransaction();
		// possible due to CascadeType.ALL
		session.save(exam);
		HibernateUtil.commitTransaction();
	}
}
