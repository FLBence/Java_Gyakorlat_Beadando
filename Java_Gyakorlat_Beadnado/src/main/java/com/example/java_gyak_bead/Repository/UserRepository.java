package com.example.java_gyak_bead.Repository;

import java.util.Optional;

import com.example.java_gyak_bead.model.User;
import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<User, Integer>
{
    Optional<User> findByEmail(String email);
}

