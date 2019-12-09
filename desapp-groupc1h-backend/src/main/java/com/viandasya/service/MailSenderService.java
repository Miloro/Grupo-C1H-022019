package com.viandasya.service;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.user.ServiceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailSenderService {
    private final JavaMailSender sender;
    private final static Logger logger = LoggerFactory.getLogger(MailSenderService.class);

    @Autowired
    public MailSenderService(JavaMailSender mailSender) {
        this.sender = mailSender;
    }

    public void sendEmail(String receiver, String body, String subject) {
        try {
            MimeMessage message = sender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setTo(receiver);
            helper.setText(body);
            helper.setSubject(subject);
            sender.send(message);

        } catch (MessagingException e) {
            logger.error(e.getMessage());
        }
    }

    public void sendMenuDischargedMessage(Menu menu, String serviceProfileEmail) {
        String body = "Hola, del equipo de Viandas Ya te comunicamos que tu menu " + menu.getName() +
                " con descripcion:"  + menu.getDescription() +
                ", tiene menos de 2 estrellas." +
                " Por lo tanto se ha dado de baja. Disculpe las molestias.";
        String subject = "Menu "+ menu.getName() +" dado de baja";
        this.sendEmail(serviceProfileEmail, body, subject);
    }

    public void sendServiceProfileDischargedMessage(ServiceInfo serviceInfo) {
        String body = "Hola, del equipo de Viandas Ya te comunicamos que tu perfil de servicio " +
                serviceInfo.getName() +
                " con descripcion:"  + serviceInfo.getDescription() +
                ", tiene menos de 2 estrellas." +
                " Por lo tanto su perfil de servicio sera dado de baja hasta nuevo aviso. Disculpe las molestias.";
        String subject = "Perfil de servicio "+ serviceInfo.getName() +" dado de baja";
        this.sendEmail(serviceInfo.geteMail(), body, subject);
    }

}
