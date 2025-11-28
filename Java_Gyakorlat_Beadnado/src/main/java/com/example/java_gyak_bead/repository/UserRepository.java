package com.example.java_gyak_bead.repository;

import java.util.Optional;

import com.example.java_gyak_bead.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{
    Optional<User> findByEmail(String email);
}

