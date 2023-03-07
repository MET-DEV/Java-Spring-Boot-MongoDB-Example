package com.metsoft.myapp.service.impl;

import com.metsoft.myapp.service.interfaces.MailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;


@Service
public class MailServiceIml implements MailService {
    private JavaMailSender mailSender;

    @Autowired
    public MailServiceIml(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public String sendMail() {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("noreply@metsoft.com");
        message.setTo("mustafatpe23@gmail.com");
        message.setText("Selamlar Bu Mesaj Size Gönderildi");
        message.setSubject("Sakın Açmaaa!!!!");
        mailSender.send(message);
        return "Gönderildi";
    }

    @Override
    public String sendMultiMediaMail() throws MessagingException {
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        MimeMessageHelper message=new MimeMessageHelper(mimeMessage,true);
        message.setFrom("noreply@metsoft.com");
        message.setTo("mustafatpe23@gmail.com");
        message.setText("Selamlar Bu Mesaj Size Gönderildi");
        message.setSubject("Sakın Açmaaa!!!!");
        FileSystemResource file=new FileSystemResource(new File("D:\\Background\\mongodb.png"));
        message.addAttachment("mongo.png",file);
        mailSender.send(mimeMessage);
        return "Gönderildi";
    }
}
