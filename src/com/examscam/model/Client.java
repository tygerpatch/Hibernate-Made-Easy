package com.examscam.model;

import java.util.List;
import java.util.Vector;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 366 created Client class
// Page: 369 added properties to Client class

public class Client {
	private List<Address> addresses = new Vector<Address>();

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	private List<Skill> skills = new Vector<Skill>();

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	private ClientDetail clientDetail;

	public ClientDetail getClientDetail() {
		return clientDetail;
	}

	public void setClientDetail(ClientDetail clientDetail) {
		this.clientDetail = clientDetail;
	}

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Boolean verified;

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
}
