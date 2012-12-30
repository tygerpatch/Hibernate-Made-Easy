package com.examscam.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 366 created Skill class
// Page: 375 added Skill properties
// Page: 382 added JPA annotations

@Entity
@Table(name = "skill", schema = "examscam")
public class Skill {
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

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Set<Client> clients;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "client_skill", joinColumns = {@JoinColumn(name = "skill_id")}, inverseJoinColumns = {@JoinColumn(name = "client_id")})
	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
}
