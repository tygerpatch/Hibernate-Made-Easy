package com.examscam.dao;

import java.util.List;

import com.examscam.model.Client;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 396 created HibernateClientDAO class

public class HibernateClientDAO extends HibernateDAO<Client, Long> implements ClientDAO {
	public HibernateClientDAO() {
		super(Client.class);
	}

	public List<Client> findAllVerified() {
		Client client = new Client();
		client.setVerified(true);
		return super.findByExample(client, null);
	}
}
