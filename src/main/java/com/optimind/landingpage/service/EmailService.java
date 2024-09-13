package com.optimind.landingpage.service;

import com.optimind.landingpage.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${contact.email.recipient}")
    private String recipientEmail;

    public void sendEmail(ContactForm contactForm) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("New Contact Form Submission from " + contactForm.getName());
        message.setText("You have a new message from your contact form.\n\n"
                + "Name: " + contactForm.getName() + "\n"
                + "Email: " + contactForm.getEmail() + "\n"
                + "Phone: " + contactForm.getPhone() + "\n"
                + "Message: " + contactForm.getMessage() + "\n");

        mailSender.send(message);
    }
}
