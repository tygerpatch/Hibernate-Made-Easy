package com.examscam.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;

import com.examscam.HibernateUtil;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 393 created HibernateDAO abstract class
// Page: 395 added findByExample and findAll methods

public abstract class HibernateDAO <T, ID extends Serializable> implements GenericDAO <T, ID> {
	private Class<T> persistentClass;

	public HibernateDAO(Class c) {
		persistentClass = c;
	}

	public T findByPrimaryKey(ID id) {
		return (T) HibernateUtil.getSession().load(persistentClass, id);
	}

	public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
		Criteria crit = HibernateUtil.getSession().createCriteria(persistentClass);
		Example example = Example.create(persistentClass);
		if(excludeProperty != null) {
			for(int i = 0; i < excludeProperty.length; i++) {
				example.excludeProperty(excludeProperty[i]);
			}
		}
		crit.add(example);
		return crit.list();
	}

	public List<T> findAll(int startIndex, int fetchSize) {
		Criteria crit = HibernateUtil.getSession().createCriteria(persistentClass);
		crit.setFirstResult(startIndex);
		crit.setFetchSize(fetchSize);
		return crit.list();
	}

	public T save(T entity) {
		HibernateUtil.getSession().saveOrUpdate(entity);
		return entity;
	}

	public void delete(T entity) {
		HibernateUtil.getSession().delete(entity);
	}

	public void beginTransaction() {
		HibernateUtil.beginTransaction();
	}

	public void commitTransaction() {
		HibernateUtil.commitTransaction();
	}
}