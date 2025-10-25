package com.insightsphere.blogapp.service.impl;

import com.insightsphere.blogapp.dto.LoginDTO;
import com.insightsphere.blogapp.dto.UserDTO;
import com.insightsphere.blogapp.repository.UserRepository;
import com.insightsphere.blogapp.service.UserService;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.insightsphere.blogapp.entity.User;
import com.insightsphere.blogapp.exception.InvalidCredentialsException;
import com.insightsphere.blogapp.exception.UserNotFoundException;
import com.insightsphere.blogapp.exception.UserValidationException;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        
        List<String> messages = validateUserUniqueness(userDTO);
        if (!messages.isEmpty()) {
            throw new UserValidationException(messages);
        }

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(User.Role.USER); 

        User savedUser = userRepository.save(user);

        return mapToDTO(savedUser);

    }

    @Override
    public List<String> validateUserUniqueness(UserDTO userDTO) {
        List<String> messages = new ArrayList<>();
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            messages.add("Email already exists!");
        }
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            messages.add("Username already exists!");
        }
        return messages;
    }

    @Override
    public UserDTO loginUser(LoginDTO loginDTO){
        User user = userRepository.findByUsername(loginDTO.getUsername()).orElseThrow(() -> new InvalidCredentialsException("Invalid username or password"));

        if(!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())){
            throw new InvalidCredentialsException("Invalid username or password");
        }

        return mapToDTO(user);

    }


    private UserDTO mapToDTO(User user) {
    UserDTO dto = new UserDTO();
    dto.setId(user.getId());
    dto.setUsername(user.getUsername());
    dto.setEmail(user.getEmail());
    dto.setRole(user.getRole());
    dto.setFirstName(user.getFirstName());
    dto.setLastName(user.getLastName());
    dto.setCreatedAt(user.getCreatedAt());
    dto.setUpdatedAt(user.getUpdatedAt());
    return dto;
}


    // Other methods remain placeholders for now
    @Override
    public UserDTO getUserById(Long id) { return null; }

    @Override
    public UserDTO getUserByEmail(String email) { return null; }

    @Override
    public UserDTO getUserByUsername(String username) { return null; }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) { return null; }

    @Override
    public boolean deleteUser(Long userId) { return false; }

    @Override
    public List<UserDTO> getAllUsers() { return null; }
}
