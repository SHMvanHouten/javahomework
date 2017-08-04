package com.github.shmvanhouten.practice.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Component
public class MailSender {

    @Autowired
    private TemplateEngine emailTemplateEngine;

    public void sendEmailToMySelf() {


        JavaMailSender mailSender = getJavaMailSender();

        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            final Context ctx = new Context();
            String emailMessage = emailTemplateEngine.process("email/templates/test-email", ctx);
            helper.setFrom("sjoerdtestmail@gmail.com");
            helper.setTo("svanhouten@gmail.com");
            helper.setSubject("test");
            helper.setText(emailMessage, true);

            FileSystemResource file = new FileSystemResource("D:\\log.txt");
            helper.addAttachment(file.getFilename(), file);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        mailSender.send(message);

    }

    private JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("sjoerdtestmail@gmail.com");
        javaMailSender.setPassword(PasswordGetter.getGmail());

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailSender.setJavaMailProperties(javaMailProperties);
        return javaMailSender;
    }
}
