package com.github.shmvanhouten.practice.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailApp implements CommandLineRunner {

    private final MailSender mailSender;

    @Autowired
    public MailApp(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public static void main(String[] args) {
        SpringApplication.run(MailApp.class);
    }

    @Override
    public void run(String... args) throws Exception {
        mailSender.sendEmailToMySelf();
    }
}
