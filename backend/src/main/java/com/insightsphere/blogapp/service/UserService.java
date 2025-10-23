package com.insightsphere.blogapp.service;

import java.util.List;

import com.insightsphere.blogapp.dto.UserDTO;
import com.insightsphere.blogapp.exception.UserNotFoundException;

public interface UserService {
    // 1. Register a new user
    UserDTO registerUser(UserDTO userDTO);

    // 2. Get user by ID
    UserDTO getUserById(Long id) throws UserNotFoundException;

    // 3. Get user by username
    UserDTO getUserByUsername(String username) throws UserNotFoundException;

    // 4. Get user by email
    UserDTO getUserByEmail(String email) throws UserNotFoundException;

    // 5. Update user details
    UserDTO updateUser(Long id, UserDTO userDTO) throws UserNotFoundException;

    // 6. Delete a user
    boolean deleteUser(Long id) throws UserNotFoundException;

    // 7. List all users
    List<UserDTO> getAllUsers();

    // 8. Check if email exists (for validation)
    boolean emailExists(String email);

    // 9. Check if username exists (for validation)
    boolean usernameExists(String username);
}
