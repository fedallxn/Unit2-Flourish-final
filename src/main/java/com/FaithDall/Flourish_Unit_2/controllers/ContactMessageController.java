package com.FaithDall.Flourish_Unit_2.controllers;

import com.FaithDall.Flourish_Unit_2.models.ContactMessage;
import com.FaithDall.Flourish_Unit_2.repositories.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("contactUs")
public class ContactMessageController {
    @Autowired
    private ContactMessageRepository contactMessageRepository;

    @PostMapping
    public ContactMessage addContactMessage(@RequestBody ContactMessage message) {
        return contactMessageRepository.save(message);
    }
}
