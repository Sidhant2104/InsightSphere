package com.insightsphere.blogapp.service.impl;

import com.insightsphere.blogapp.dto.UserDTO;
import com.insightsphere.blogapp.exception.EmailAlreadyExistsException;
import com.insightsphere.blogapp.exception.UsernameAlreadyExistsException;
import com.insightsphere.blogapp.repository.UserRepository;
import com.insightsphere.blogapp.service.UserService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO registerUser(UserDTO userDTO) {
        
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

    public boolean emailExists(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Email " + userDTO.getEmail() + " is already in use!");
        }
        if(userRepository.existsByUsername(userDTO.getUsername())){
            throw new UsernameAlreadyExistsException("Username " + userDTO.getUsername() + "already exists!");
        }
        return false;
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
