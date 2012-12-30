package com.examscam.dao;

import com.examscam.model.ClientDetail;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 396 created HibernateClientDetailDAO class

public class HibernateClientDetailDAO extends HibernateDAO<ClientDetail, Long> implements ClientDetailDAO {
	public HibernateClientDetailDAO() {
		super(ClientDetail.class);
	}
}