package com.example.java_gyak_bead.model;
import jakarta.persistence.*;

@Entity
@Table(name = "eredmeny")
public class Eredmeny {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String pilota;
    private String csapat;
    private Integer helyezes;
}
