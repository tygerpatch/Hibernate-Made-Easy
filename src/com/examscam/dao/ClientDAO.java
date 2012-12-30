package com.examscam.dao;

import java.util.List;

import com.examscam.model.Client;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 391 created ClientDAO interface

public interface ClientDAO extends GenericDAO<Client, Long> {
	public List<Client> findAllVerified();
}
