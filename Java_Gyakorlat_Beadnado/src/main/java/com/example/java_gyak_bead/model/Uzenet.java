package com.example.java_gyak_bead.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "uzenetek")
public class Uzenet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "A név megadása kötelező.")
    @Size(max = 100)
    private String nev;

    @NotBlank(message = "Az email megadása kötelező.")
    @Email(message = "Érvényes email címet adjon meg.")
    @Size(max = 150)
    private String email;

    @NotBlank(message = "Az üzenet nem lehet üres.")
    private String uzenet;

    private LocalDateTime kuldve;

    @PrePersist
    public void onCreate() {
        this.kuldve = LocalDateTime.now();
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNev() { return nev; }
    public void setNev(String nev) { this.nev = nev; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUzenet() { return uzenet; }
    public void setUzenet(String uzenet) { this.uzenet = uzenet; }

    public LocalDateTime getKuldve() { return kuldve; }
    public void setKuldve(LocalDateTime kuldve) { this.kuldve = kuldve; }
}
