package com.gbeedev.userservice.repositories;

import com.gbeedev.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // if you want to implement any custom method or query
    Optional<User> findByEmail(String email);

}
