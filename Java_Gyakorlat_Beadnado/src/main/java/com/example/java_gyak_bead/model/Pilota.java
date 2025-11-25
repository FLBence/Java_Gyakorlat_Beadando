package com.example.java_gyak_bead.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pilota")
public class Pilota {
    @Id
    private Integer az;
    private String nev;
    private String nemzet;
}
