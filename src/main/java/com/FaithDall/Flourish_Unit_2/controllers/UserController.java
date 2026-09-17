package com.FaithDall.Flourish_Unit_2.controllers;

import com.FaithDall.Flourish_Unit_2.models.User;
import com.FaithDall.Flourish_Unit_2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("{userId}")
    public ResponseEntity<Object> getUser(@PathVariable int userId) {
        User currentUser = userRepository.findById(userId).orElse(null);
        if (currentUser == null) {
            return ResponseEntity.status(404).body("User not found.");
        } else {
            return ResponseEntity.ok(currentUser);
        }
    }
    @PutMapping("{userId}")
    public ResponseEntity<Object> updateUser(@PathVariable int userId, @RequestBody User user) {
        User currentUser = userRepository.findById(userId).orElse(null);
        if (currentUser == null) {
            return ResponseEntity.status(404).body("User not found.");
        } else {
            currentUser.setUsername(user.getUsername());
            currentUser.setPassword(user.getPassword());
            currentUser.setName(user.getName());
            currentUser.setPetType(user.getPetType());
            return ResponseEntity.ok(userRepository.save(currentUser));
        }
    }
    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable int userId) {
        userRepository.deleteById(userId);
    }
}
