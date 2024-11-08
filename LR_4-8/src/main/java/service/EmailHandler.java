package service;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


public class EmailHandler extends Handler {

    @Override
    public void publish(LogRecord record) {
        if (record.getLevel().intValue() >= Level.SEVERE.intValue()) {
            sendEmail(record);
        }
    }

    private void sendEmail(LogRecord record) {
        // Налаштування облікового запису електронної пошти
        final String username = "diana-marta.lopska.oi.2023@lpnu.ua";  // Вкажіть свою електронну пошту
        final String password = "quhenzulophzdmwi";         // Вкажіть пароль
        final String recipient = "lopskadiana@gmail.com"; // Email для отримання критичних сповіщень

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject("Critical Error in Application");
            message.setText("A critical error occurred: \n" + record.getMessage());

            Transport.send(message);
            System.out.println("Email sent successfully for critical error.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void flush() {}

    @Override
    public void close() throws SecurityException {}
}
