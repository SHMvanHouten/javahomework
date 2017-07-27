package com.github.shmvanhouten.practice.email;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {
    public static void main(String[] args) {
        MailSender mailSender = new MailSender();
        mailSender.sendEmailToMySelf();
    }



    private void sendEmailToMySelf() {
        JavaMailSender mailSender = getJavaMailSender();

        MimeMessage message = mailSender.createMimeMessage();

        try{
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("svanhouten@gmail.com");
            helper.setTo("svanhouten@gmail.com");
            helper.setSubject("test");
            helper.setText("this is a test");

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
        javaMailSender.setUsername("svanhouten@gmail.com");
        javaMailSender.setPassword(PasswordGetter.getGmail());

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailSender.setJavaMailProperties(javaMailProperties);
        return javaMailSender;
    }
}
