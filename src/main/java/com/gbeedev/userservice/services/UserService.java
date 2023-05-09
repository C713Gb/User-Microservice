package com.gbeedev.userservice.services;

import com.gbeedev.userservice.entities.User;

import java.util.List;

public interface UserService {

    // user operations

    // create
    User saveUser(User user);

    // check user exists by email
    boolean existsByEmail(String email);

    // get all users
    List<User> getAllUsers();

    // get single user by id
    User getUserById(Long id);

    // delete user
    void deleteUser(User user);

}
