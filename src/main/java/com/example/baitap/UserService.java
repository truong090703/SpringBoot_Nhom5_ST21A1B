package com.example.baitap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    // Retrieve a user by their ID
    public UserDemo getUserById(int id) {
        Optional<UserDemo> user = userRepository.findById(id);
        return user.orElse(null);
    }


    public void updateUser(int id, UserDemo updatedUser) {
        Optional<UserDemo> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            UserDemo user = existingUser.get();
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setDob(updatedUser.getDob());
            user.setHometown(updatedUser.getHometown());
            userRepository.save(user);
        }
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
