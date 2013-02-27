package com.examscam.dao.interfaces;

import java.util.List;

import com.examscam.model.User;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie
// Page: 220 created UserDAO interface
public interface UserDAO {
  public User create(User user);
  public boolean update(User user);
  public boolean delete(User user);
  public User findByPrimaryKey(Long primaryKey);
  public List findByExample(User user, boolean fuzzy);
  public List findAll();
}
