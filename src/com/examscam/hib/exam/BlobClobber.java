package com.examscam.hib.exam;

import java.sql.Blob;
import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

//Title: Hibernate Made Easy
//Author: Cameron McKenzie

//Page  62 Created BlobClobber class

@Entity
@Table(name = "BlobClobBoBob", schema = "examscam")
public class BlobClobber {

    private Long id;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    private String beans;

    @Lob
    public String getBeans() {
        return beans;
    }

    private char[] ming;

    @Lob
    public char[] getMing() {
        return ming;
    }

    private Character[] witness;

    @Lob
    public Character[] getWitness() {
        return witness;
    }

    private Clob sqlClob;

    @Lob
    public Clob getSqlClob() {
        return sqlClob;
    }

    private Blob sqlBlob;

    @Lob
    public Blob getSqlBlob() {
        return sqlBlob;
    }

    private byte[] me;

    @Lob
    public byte[] getMe() {
        return me;
    }


    public static void main(String args[]) {
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.addAnnotatedClass(BlobClobber.class).configure();
        new SchemaExport(config).create(true, true);
    }
}
