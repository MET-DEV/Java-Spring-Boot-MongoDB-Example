package com.metsoft.myapp.api;

import com.metsoft.myapp.service.interfaces.MailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
public class MailController {
    private final MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/normal")
    public ResponseEntity<String> sendNormalMail(){
        return ResponseEntity.ok(mailService.sendMail());
    }
    @GetMapping("/multi")
    public ResponseEntity<String> sendMultiMail() throws MessagingException {
        return  ResponseEntity.ok(mailService.sendMultiMediaMail());
    }
}
