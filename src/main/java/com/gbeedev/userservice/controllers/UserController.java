package com.gbeedev.userservice.controllers;

import com.gbeedev.userservice.entities.User;
import com.gbeedev.userservice.exceptions.ResourceNotFoundException;
import com.gbeedev.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    // get single user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    // delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(user);
        return ResponseEntity.noContent().build();
    }

}
