package org.ngphthinh.servlet;

import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.ngphthinh.service.MailService;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/send-mail")
@MultipartConfig
public class EmailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String receiver = req.getParameter("receiver");
        String subject = req.getParameter("subject");
        String message = req.getParameter("content");

        System.out.println(receiver);
        System.out.println(subject);
        System.out.println(message);
        Part[] attachmentPart = req.getParts()
                .stream()
                .filter(part -> "attachments".equals(part.getName()))
                .toArray(Part[]::new);
        System.out.println(Arrays.toString(attachmentPart));
        try {
            MailService.sendEmail(receiver, subject, message, attachmentPart);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("<h2>The email has been sent successfully.</h2>");
    }
}
