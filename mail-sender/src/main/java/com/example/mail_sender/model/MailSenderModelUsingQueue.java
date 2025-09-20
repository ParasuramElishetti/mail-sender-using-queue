package com.example.mail_sender.model;

import java.util.List;

public class MailSenderModelUsingQueue {
    private String fromEmail;
    private String fromName;
    private List<String> emails;
    private List<String> cc;
    private List<String> bcc;
    private String subject;
    private String message;

    public MailSenderModelUsingQueue() {}


    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public MailSenderModelUsingQueue(String fromEmail, String fromName, List<String> emails, List<String> cc, List<String> bcc, String subject, String message) {
        this.fromEmail = fromEmail;
        this.fromName = fromName;
        this.emails = emails;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.message = message;
    }
}
