# Mail Sender Project

# Mail Sender Project

This is a Spring Boot project that sends emails using a queue.

## Features
- Send emails to TO, CC, and BCC recipients
- Queue-based email processing
- Spring Boot + JavaMailSender

## Usage
1. Configure `application.properties` with your Gmail credentials
2. Use the API endpoint `/api/v1/send-mail` to send emails
3. Payload supports `to`, `cc`, and `bcc` fields

## API Endpoints
- `/api/v1/send-mail`: Send email using a queue

## Dependencies
- Spring Boot
- JavaMailSender

## Application Properties

These are the main properties used in the project:

- `spring.application.name` → Name of the application (e.g., mail-sender)
- `server.port` → Port where the app runs (e.g., 8089)
- `spring.mail.host` → SMTP server (e.g., smtp.gmail.com)
- `spring.mail.port` → SMTP port (e.g., 587 for TLS)
- `spring.mail.username` → Email address used to send emails
- `spring.mail.password` → Password or app-specific password for the email account
- `spring.mail.properties.mail.smtp.auth` → Enable SMTP authentication (`true`)
- `spring.mail.properties.mail.smtp.starttls.enable` → Enable secure connection (`true`)  



