package com.insightsphere.blogapp.service.impl;

import com.insightsphere.blogapp.dto.UserDTO;
import com.insightsphere.blogapp.exception.EmailAlreadyExistsException;
import com.insightsphere.blogapp.exception.UsernameAlreadyExistsException;
import com.insightsphere.blogapp.repository.UserRepository;
import com.insightsphere.blogapp.service.UserService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO registerUser(UserDTO userDTO) {
        // TODO: Implement user registration logic
        return null;
    }

    public UserDTO getUserById(Long id) {
        // Implementation for getting a user by ID
        return null;
    } 
    
    public UserDTO getUserByEmail(String email) {
        // wait
        return null;
    }

    public UserDTO getUserByUsername(String username) {
        // Implementation for getting a user by username
        return null;
    }

    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        // Implementation for updating a user
        return null;
    }

    public boolean deleteUser(Long userId) {
        // Implementation for deleting a user
        return false;
    }

    public List<String> emailExists(UserDTO userDTO) {
        List<String> messages = new ArrayList<>();
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            messages.add("Email already exists!");
        }
        if(userRepository.existsByUsername(userDTO.getUsername())){
            messages.add("Username already exists!");
        }
        return messages;
    }

    public boolean usernameExists(String username) {
        // Implementation for checking if a username exists
        return false;
    }

    public List<UserDTO> getAllUsers() {
        // Implementation for getting all users
        return null;
    }

  
}
