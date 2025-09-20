package com.example.mail_sender.controller;

import com.example.mail_sender.model.MailSenderModelUsingQueue;
import com.example.mail_sender.service.MailSenderServiceUsingQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MailSenderUsingQueueController {

    @Autowired
    private MailSenderServiceUsingQueue queueService;


    @PostMapping("/send-mail")
    public ResponseEntity<String> sendMail(@RequestBody MailSenderModelUsingQueue mailRequest) {
        if(mailRequest.getEmails() == null || mailRequest.getEmails().isEmpty()) {
            return ResponseEntity.status(550)
                    .body("Error 550 - No recipients defined. Please provide at least one 'to' address.");
        }
            queueService.addToQueue(mailRequest);

        StringBuilder response = new StringBuilder("Email sent to: " + mailRequest.getEmails());

        if (mailRequest.getCc() != null && !mailRequest.getCc().isEmpty()) {
            response.append("\nCC: ").append(mailRequest.getCc());
        }
        if (mailRequest.getBcc() != null && !mailRequest.getBcc().isEmpty()) {
            response.append("\nBCC: ").append(mailRequest.getBcc());
        }

        return ResponseEntity.ok(response.toString());
    }

}
