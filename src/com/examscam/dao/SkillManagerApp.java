package com.examscam.dao;

import com.examscam.dao.interfaces.AddressDAO;
import com.examscam.dao.interfaces.ClientDAO;
import com.examscam.dao.interfaces.ClientDetailDAO;
import com.examscam.dao.interfaces.SkillDAO;
import com.examscam.model.Address;
import com.examscam.model.Client;
import com.examscam.model.ClientDetail;
import com.examscam.model.Skill;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 405 created SkillManagerApp class

public class SkillManagerApp {
  public static void main(String[] args) {
    DAOFactory factory = DAOFactory.getFactory();
    factory.getClientDAO().beginTransaction();
    ClientDAO clientDAO = factory.getClientDAO();
    ClientDetailDAO clientDetailDAO = factory.getClientDetailDAO();
    SkillDAO skillDAO = factory.getSkillDAO();
    AddressDAO addressDAO = factory.getAddressDAO();
    Client client = new Client();
    client.setUsername("me");
    client.setPassword("passw0rd");
    ClientDetail detail = new ClientDetail();
    detail.setEmailAddress("mail@scja.com");
    detail.setFirstName("Cameron");
    detail.setLastName("McKenzie");
    client.setClientDetail(detail);
    Address address = new Address();
    address.setAddressLine1("390 Queens Quay");
    address.setAddressLine2("apt 2301");
    address.setCity("Toronto");
    address.setCountry("Canada");
    address.setClient(client);
    client.getAddresses().add(address);
    Skill basting = new Skill();
    basting.setName("turkey basting");
    client.getSkills().add(basting);
    Skill kicking = new Skill();
    kicking.setName("tire kicking");
    // kicking not added as a skill
    Skill polishing = new Skill();
    polishing.setName("shoe polishing");
    client.getSkills().add(polishing);
    clientDAO.save(client);
    clientDetailDAO.save(detail);
    addressDAO.save(address);
    skillDAO.save(basting);
    skillDAO.save(kicking);
    skillDAO.save(polishing);
    factory.getClientDAO().commitTransaction();
  }
}
