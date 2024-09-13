package com.optimind.landingpage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.optimind.landingpage.model.ContactForm;
import com.optimind.landingpage.service.EmailService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitContactForm(@RequestBody ContactForm contactForm) {
        emailService.sendEmail(contactForm);
        return ResponseEntity.ok("Email sent successfully");
    }
}

