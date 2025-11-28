package com.example.java_gyak_bead.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.time.LocalDate;

@Entity
@Table(name = "eredmeny")
public class Eredmeny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datum")
    private LocalDate datum;

    private int pilotaaz;
    private Integer helyezes;
    private String hiba;
    private String csapat;
    private String tipus;
    private String motor;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDatum() { return datum; }
    public void setDatum(LocalDate datum) { this.datum = datum; }

    public int getPilotaaz() { return pilotaaz; }
    public void setPilotaaz(int pilotaaz) { this.pilotaaz = pilotaaz; }

    public Integer getHelyezes() { return helyezes; }
    public void setHelyezes(Integer helyezes) { this.helyezes = helyezes; }

    public String getHiba() { return hiba; }
    public void setHiba(String hiba) { this.hiba = hiba; }

    public String getCsapat() { return csapat; }
    public void setCsapat(String csapat) { this.csapat = csapat; }

    public String getTipus() { return tipus; }
    public void setTipus(String tipus) { this.tipus = tipus; }

    public String getMotor() { return motor; }
    public void setMotor(String motor) { this.motor = motor; }
}