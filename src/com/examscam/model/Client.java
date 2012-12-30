package com.examscam.model;

import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 366 created Client class
// Page: 369 added properties to Client class
// Page: 376 added JPA annotations
// Page: 378 added OneToMany annotation for getAddresses
// Page: 381 added ManyToMany annotation for getSkills

@Entity
@Table(name = "client", schema = "examscam")
public class Client {
	private List<Address> addresses = new Vector<Address>();

	@OneToMany(mappedBy = "client", targetEntity = Address.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	private List<Skill> skills = new Vector<Skill>();

	@ManyToMany
	@JoinTable(name = "client_skill", joinColumns = {@JoinColumn(name = "client_id")}, inverseJoinColumns = {@JoinColumn(name = "skill_id")})
	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	private ClientDetail clientDetail;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "detail_id")
	public ClientDetail getClientDetail() {
		return clientDetail;
	}

	public void setClientDetail(ClientDetail clientDetail) {
		this.clientDetail = clientDetail;
	}

	private Long id;

	@Id
	@GeneratedValue
	@Column(name = "id")
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