package com.example.java_gyak_bead.model;
import jakarta.persistence.*;

@Entity
@Table(name = "gp")
public class Gp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nev;
    private String helyszin;
}
