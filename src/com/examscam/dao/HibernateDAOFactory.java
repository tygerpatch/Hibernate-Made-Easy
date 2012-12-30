package com.examscam.dao;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 403 created HibernateDAOFactory class

public class HibernateDAOFactory extends DAOFactory {
	public ClientDAO getClientDAO() {
		return new HibernateClientDAO();
	}

	public ClientDetailDAO getClientDetailDAO() {
		return new HibernateClientDetailDAO();
	}

	public AddressDAO getAddressDAO() {
		return new HibernateAddressDAO();
	}

	public SkillDAO getSkillDAO() {
		return new HibernateSkillDAO();
	}
}