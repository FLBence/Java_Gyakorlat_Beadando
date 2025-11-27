package com.example.java_gyak_bead.model;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "eredmeny")
public class Eredmeny {

    @EmbeddedId
    private EredmenyId id;

    @Column(name = "helyezes")
    private Integer helyezes;

    @Column(name = "hiba")
    private String hiba;

    @Column(name = "csapat")
    private String csapat;

    @Column(name = "tipus")
    private String tipus;

    @Column(name = "motor")
    private String motor;

    public EredmenyId getId() {
        return id;
    }

    public void setId(EredmenyId id) {
        this.id = id;
    }

    public Integer getHelyezes() {
        return helyezes;
    }

    public void setHelyezes(Integer helyezes) {
        this.helyezes = helyezes;
    }

    public String getHiba() {
        return hiba;
    }

    public void setHiba(String hiba) {
        this.hiba = hiba;
    }

    public String getCsapat() {
        return csapat;
    }

    public void setCsapat(String csapat) {
        this.csapat = csapat;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }
}
