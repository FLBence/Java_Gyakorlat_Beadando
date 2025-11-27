package com.example.java_gyak_bead.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pilota")
public class Pilota {

    @Id
    @Column(name = "az")
    private Integer id;

    private String nev;
    private Character nem;
    private Date szuldat;
    private String nemzet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Character getNem() {
        return nem;
    }

    public void setNem(Character nem) {
        this.nem = nem;
    }

    public Date getSzuldat() {
        return szuldat;
    }

    public void setSzuldat(Date szuldat) {
        this.szuldat = szuldat;
    }

    public String getNemzet() {
        return nemzet;
    }

    public void setNemzet(String nemzet) {
        this.nemzet = nemzet;
    }
}
