package com.sat.tmf.productrest.service;

import org.springframework.stereotype.Service;

import com.sat.tmf.productrest.entity.User;
import com.sat.tmf.productrest.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}

