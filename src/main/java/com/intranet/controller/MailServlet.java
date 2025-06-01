package com.intranet.controller;

import com.intranet.model.Mail;
import com.intranet.model.User;
import com.intranet.service.MailDAOImpl;
import com.intranet.service.UserDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/sendmail")
public class MailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User sender = (User) session.getAttribute("user");
        
        if (sender == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String body = request.getParameter("body");

        // Validate recipient exists in the database
        if (!isValidRecipient(recipient)) {
            request.setAttribute("error", "Recipient College ID does not exist");
            request.getRequestDispatcher("compose.jsp").forward(request, response);
            return;
        }

        Mail mail = new Mail();
        mail.setSenderId(sender.getCollegeId());
        mail.setRecipientId(recipient);
        mail.setSubject(subject);
        mail.setBody(body);

        try {
            MailDAOImpl mailDao = new MailDAOImpl();
            boolean isSent = mailDao.sendMail(mail);
            
            if (isSent) {
                response.sendRedirect("dashboard.jsp");
            } else {
                request.setAttribute("error", "Failed to send email");
                request.getRequestDispatcher("compose.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error: " + e.getMessage());
            request.getRequestDispatcher("compose.jsp").forward(request, response);
        }
    }

    // Check if recipient exists in users table
    private boolean isValidRecipient(String recipientId) {
    UserDAOImpl userDao = new UserDAOImpl();
    return userDao.userExists(recipientId);
}
}