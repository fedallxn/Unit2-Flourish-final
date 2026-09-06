package com.FaithDall.Flourish_Unit_2.controllers;

import com.FaithDall.Flourish_Unit_2.models.User;
import com.FaithDall.Flourish_Unit_2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("{userId}")
    public User getUser(@PathVariable int userId) {
        return userRepository.findById(userId).orElse(null);
    }
    @PutMapping("{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User user) {
        User currentUser = userRepository.findById(userId).orElse(null);
        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());
        currentUser.setPetType(user.getPetType());
        return userRepository.save(currentUser);
    }
    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable int userId) {
        userRepository.findById(userId);
    }
}
