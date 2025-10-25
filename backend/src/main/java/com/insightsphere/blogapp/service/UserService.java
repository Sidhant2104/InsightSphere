package com.insightsphere.blogapp.service;

import java.util.List;

import com.insightsphere.blogapp.dto.LoginDTO;
import com.insightsphere.blogapp.dto.UserDTO;
import com.insightsphere.blogapp.exception.UserNotFoundException;

public interface UserService {

    // 1. Register a new user
    UserDTO registerUser(UserDTO userDTO);

    //2. Login a user
    UserDTO loginUser(LoginDTO loginDTO);


    // 3. Get user by ID
    UserDTO getUserById(Long id) throws UserNotFoundException;

    // 4. Get user by username
    UserDTO getUserByUsername(String username) throws UserNotFoundException;

    // 5. Get user by email
    UserDTO getUserByEmail(String email) throws UserNotFoundException;

    // 6. Update user details
    UserDTO updateUser(Long id, UserDTO userDTO) throws UserNotFoundException;

    // 7. Delete a user
    boolean deleteUser(Long id) throws UserNotFoundException;

    // 8. List all users
    List<UserDTO> getAllUsers();

    // 9. Validate email and username uniqueness
    List<String> validateUserUniqueness(UserDTO userDTO);
}
