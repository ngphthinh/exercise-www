package org.ngphthinh.service;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import org.ngphthinh.config.Config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class MailService {
    public static void sendEmail(String to, String subject, String body, jakarta.servlet.http.Part... files) throws MessagingException {
        Properties props = new Properties();

        String from = Config.get("mail.email");
        String password = Config.get("mail.password");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(
                props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                from,
                                password
                        );
                    }
                }
        );

        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(to)
        );

        Multipart multipart = new MimeMultipart();
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(body);
        multipart.addBodyPart(messageBodyPart);

        if (files != null) {
            for (jakarta.servlet.http.Part file : files) {
                MimeBodyPart attachmentBodyPart = getAttachmentBodyPart(file);
                multipart.addBodyPart(attachmentBodyPart);
            }
        }
        message.setSubject(subject);
        message.setContent(multipart);

        Transport.send(message);
    }

    private static MimeBodyPart getAttachmentBodyPart(jakarta.servlet.http.Part file)
            throws MessagingException {

        MimeBodyPart attachment = new MimeBodyPart();

        DataSource source = new DataSource() {

            @Override
            public InputStream getInputStream() throws IOException {
                try {
                    return file.getInputStream();
                } catch (Exception e) {
                    throw new IOException(e);
                }
            }

            @Override
            public OutputStream getOutputStream() {
                throw new UnsupportedOperationException();
            }

            @Override
            public String getContentType() {
                try {
                    return file.getContentType();
                } catch (Exception e) {
                    return "application/octet-stream";
                }
            }

            @Override
            public String getName() {
                return file.getSubmittedFileName();
            }
        };

        attachment.setDataHandler(new DataHandler(source));
        attachment.setFileName(file.getSubmittedFileName());

        return attachment;
    }
}
