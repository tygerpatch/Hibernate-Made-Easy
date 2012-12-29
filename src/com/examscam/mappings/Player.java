package com.examscam.mappings;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 336 created Player class
// Page: 337 added team property
// Page: 339 added basic JPA Annotations
// Page: 343 added annotations for ManyToOne association

@Entity
public class Player {
	private long id;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private String nickName;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String n) {
		this.nickName = n;
	}

	private Team team;

	@ManyToOne
	@JoinColumn(name = "team_id")
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
