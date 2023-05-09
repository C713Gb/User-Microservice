package com.gbeedev.userservice.services.impl;

import com.gbeedev.userservice.entities.User;
import com.gbeedev.userservice.exceptions.EmailAlreadyExistsException;
import com.gbeedev.userservice.exceptions.MissingFieldsException;
import com.gbeedev.userservice.exceptions.ResourceNotFoundException;
import com.gbeedev.userservice.repositories.UserRepository;
import com.gbeedev.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {

        validateUser(user);

        if (!existsByEmail(user.getEmail()))
            return userRepository.save(user);
        else
            throw new EmailAlreadyExistsException("A user with the email '" + user.getEmail() + "' already exists.");
    }

    private void validateUser(User user) {
        if (user.getFirstName() == null)
            throw new MissingFieldsException("The request body is missing the 'firstName' field.");
        else if (user.getLastName() == null)
            throw new MissingFieldsException("The request body is missing the 'lastName' field.");
        else if (user.getEmail() == null)
            throw new MissingFieldsException("The request body is missing the 'email' field.");
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + id));
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

}
