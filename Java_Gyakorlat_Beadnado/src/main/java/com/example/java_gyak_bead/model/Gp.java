package com.example.java_gyak_bead.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gp")
public class Gp {

    @Id
    @Column(name = "datum")
    private Date datum;

    @Column(name = "nev")
    private String nev;

    @Column(name = "helyszin")
    private String helyszin;

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getHelyszin() {
        return helyszin;
    }

    public void setHelyszin(String helyszin) {
        this.helyszin = helyszin;
    }
}