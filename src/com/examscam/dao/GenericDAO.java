package com.examscam.dao;

import java.io.Serializable;
import java.util.List;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 389 created GenericDAO interface

public interface GenericDAO<T, ID extends Serializable> {
	T findByPrimaryKey(ID id);
	List<T> findAll(int startIndex, int fetchSize);
	List<T> findByExample(T exampleInstance, String[] excludeProperty);
	T save(T entity);
	void delete(T entity);
	void beginTransaction();
	void commitTransaction();
}
