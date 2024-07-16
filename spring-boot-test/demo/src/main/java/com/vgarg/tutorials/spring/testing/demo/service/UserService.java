package com.vgarg.tutorials.spring.testing.demo.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vgarg.tutorials.spring.testing.demo.entity.User;
import com.vgarg.tutorials.spring.testing.demo.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }
}
