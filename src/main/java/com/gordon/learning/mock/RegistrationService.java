package com.gordon.learning.mock;

public class RegistrationService {

    private final EmailService emailService;

    public RegistrationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void register(String recipient) {
        // store into a repository
        // anything else before sending mail.

        // send a mail
        emailService.sendWelcomeEmail(recipient);
    }
}
