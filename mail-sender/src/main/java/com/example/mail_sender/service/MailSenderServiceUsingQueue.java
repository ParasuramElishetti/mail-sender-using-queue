package com.example.mail_sender.service;

import com.example.mail_sender.model.MailSenderModelUsingQueue;
import jakarta.annotation.PostConstruct;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class MailSenderServiceUsingQueue {

    private BlockingQueue<MailSenderModelUsingQueue> queue = new LinkedBlockingQueue<MailSenderModelUsingQueue>();

    @Autowired
    private JavaMailSender mailSender;

    // Enqueue method
    public void addToQueue(MailSenderModelUsingQueue mailRequest) {
        queue.offer(mailRequest);
    }

    @PostConstruct
    public void startMailConsumer() {
        Thread consumerThread = new Thread(() -> {
            while (true) {
                try {
                    MailSenderModelUsingQueue request = queue.take();
                    sendMail(request);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        consumerThread.setDaemon(true);
        consumerThread.start();
    }

    private void sendMail(MailSenderModelUsingQueue request) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String fromEmail = request.getFromEmail() != null ? request.getFromEmail() : "elishettiparasuram@gmail.com";
        String fromName = request.getFromName() != null ? request.getFromName() : "Parasuram Elishetti";
        helper.setFrom(fromEmail, fromName);

        if (request.getEmails() != null && !request.getEmails().isEmpty()) {
            helper.setTo(request.getEmails().toArray(new String[0]));
        }

        if (request.getCc() != null && !request.getCc().isEmpty()) {
            helper.setCc(request.getCc().toArray(new String[0]));
        }

        if (request.getBcc() != null && !request.getBcc().isEmpty()) {
            helper.setBcc(request.getBcc().toArray(new String[0]));
        }

        helper.setSubject(request.getSubject());
        helper.setText(request.getMessage(), true);

        mailSender.send(message);
    }

}
