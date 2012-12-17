package com.examscam.dao;

import org.hibernate.Session;

import com.examscam.HibernateUtil;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 223 created ExamScamDAO abstract class

public abstract class ExamScamDAO {

    protected Session getSession() {
        return HibernateUtil.getSession();
    }

    protected void save(Object pojo) {
        this.getSession().saveOrUpdate(pojo);
    }

    protected void delete(Object pojo) {
        this.getSession().delete(pojo);
    }

    protected Object findByPrimaryKey(Class c, Long primaryKey) {
        return this.getSession().get(c, primaryKey);
    }
}
