package com.example.java_gyak_bead.Repository;

import com.example.java_gyak_bead.model.Eredmeny;
import com.example.java_gyak_bead.model.EredmenyId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EredmenyRepository extends JpaRepository<Eredmeny, EredmenyId> {
}
