package com.examscam.dao;

import com.examscam.model.Address;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 396 created HibernateAddressDAO class

public class HibernateAddressDAO extends HibernateDAO<Address, Long> implements AddressDAO {
	public HibernateAddressDAO() {
		super(Address.class);
	}
}