package com.examscam.mappings;

import com.examscam.HibernateUtil;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import org.hibernate.Session;

// Title: Hibernate Made Easy
// Author: Cameron McKenzie

// Page: 302 Fracture class

@Entity
@IdClass(com.examscam.mappings.CompoundKey.class)
public class Fracture {
    Long bankId;

    @Id
    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    Long userId;

    @Id
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    String bone;

    public String getBone() {
        return bone;
    }

    public void setBone(String bone) {
        this.bone = bone;
    }

    public static void main(String[] args) {
        Fracture bone = new Fracture();
        bone.setBone("arm");
        bone.setBankId(new Long(99));
        bone.setUserId(new Long(88));
        HibernateUtil.recreateDatabase();
        Session session = HibernateUtil.beginTransaction();
        session.save(bone);
        HibernateUtil.commitTransaction();
    }
}
