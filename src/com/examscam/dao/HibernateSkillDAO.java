package com.examscam.dao;

import com.examscam.dao.interfaces.SkillDAO;
import com.examscam.model.Skill;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie
// Page: 396 created HibernateSkillDAO class
public class HibernateSkillDAO extends HibernateDAO<Skill, Long> implements SkillDAO {
  public HibernateSkillDAO() {
    super(Skill.class);
  }
}
