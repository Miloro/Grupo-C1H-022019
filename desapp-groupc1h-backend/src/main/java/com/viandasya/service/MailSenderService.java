package com.viandasya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class MailSenderService {
    private final JavaMailSender sender;

    @Autowired
    public MailSenderService(JavaMailSender mailSender) {
        this.sender = mailSender;
    }

    public void sendEmail(String receiver, String body, String subject) throws Exception {
        MimeMessage message = sender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(receiver);
        helper.setText(body);
        helper.setSubject(subject);

        sender.send(message);
    }
}
