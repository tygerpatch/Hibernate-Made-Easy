package com.examscam.mappings;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.Session;

import com.examscam.HibernateUtil;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 336 created Team class
// Page: 337 added players property
// Page: 339 added basic JPA Annotations
// Page: 343 added annotations for OneToMany association
// Page: 347 added static void main method

@Entity
public class Team {
	private long id;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setid(long id) {
		this.id = id;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private List<Player> players;

	@OneToMany(mappedBy = "team", targetEntity = Player.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public static void main(String[] args) {
		HibernateUtil.recreateDatabase();
		Session session = HibernateUtil.beginTransaction();
		Team team = new Team();
		Player player1 = new Player();
		Player player2 = new Player();
		session.save(team);
		session.save(player1);
		session.save(player2);
		team.setName("Pickering Atoms");
		player1.setNickName("Lefty");
		player1.setTeam(team);
		player2.setNickName("Blinky");
		player2.setTeam(team);
		HibernateUtil.commitTransaction();
	}
}
