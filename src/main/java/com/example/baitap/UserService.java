package com.example.baitap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserDemo user) {
        userRepository.save(user);
    }

    public List<UserDemo> getAllUsers() {
        return (List<UserDemo>) userRepository.findAll();
    }
}