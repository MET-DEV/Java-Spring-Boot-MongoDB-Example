package com.metsoft.myapp.service.interfaces;

import jakarta.mail.MessagingException;

public interface MailService {
    String sendMail();
    String sendMultiMediaMail() throws MessagingException;
}
