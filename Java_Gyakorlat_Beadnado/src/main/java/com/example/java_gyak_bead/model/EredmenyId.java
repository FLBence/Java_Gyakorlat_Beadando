package com.example.java_gyak_bead.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class EredmenyId implements Serializable {

    @Column(name = "datum")
    private Date datum;

    @Column(name = "pilotaaz")
    private Integer pilotaAz;

    public EredmenyId() {}

    public EredmenyId(Date datum, Integer pilotaAz) {
        this.datum = datum;
        this.pilotaAz = pilotaAz;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Integer getPilotaAz() {
        return pilotaAz;
    }

    public void setPilotaAz(Integer pilotaAz) {
        this.pilotaAz = pilotaAz;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EredmenyId that = (EredmenyId) o;
        return Objects.equals(datum, that.datum) &&
                Objects.equals(pilotaAz, that.pilotaAz);
    }


    @Override
    public int hashCode() {
        return Objects.hash(datum, pilotaAz);
    }
}
