package com.examscam.dao;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 399 created DAOFactory class

public abstract class DAOFactory {
	public static final Class FACTORY_CLASS = HibernateDAOFactory.class;
	// public static final Class FACTORY_CLASS = JDBCDAOFactory.class
	// public static final Class FACTORY_CLASS = JDODAOFactory.class

	public static DAOFactory getFactory() {
		try {
			return (DAOFactory) FACTORY_CLASS.newInstance();
		} catch(Exception e) {
			throw new RuntimeException("Couldn't create Factory");
		}
	}

	public abstract ClientDAO getClientDAO();
	public abstract ClientDetailDAO getClientDetailDAO();
	public abstract AddressDAO getAddressDAO();
	public abstract SkillDAO getSkillDAO();
}