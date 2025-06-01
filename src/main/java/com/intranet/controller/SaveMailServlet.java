package com.intranet.controller;

import com.intranet.model.Mail;
import com.intranet.model.User;
import com.intranet.service.MailDAOImpl;
import com.intranet.service.UserDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/savemail") // Map to URL /savemail
public class SaveMailServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String action = request.getParameter("action"); // "send" or "draft"

        // Check if user is logged in
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Get form data
        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String body = request.getParameter("body");

        // Validate required fields
        if (recipient == null || recipient.isEmpty() || 
            subject == null || subject.isEmpty() || 
            body == null || body.isEmpty()) {
            
            request.setAttribute("error", "All fields are required");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        // Validate recipient exists (only for "Send" action)
        if ("send".equals(action)) {
            UserDAOImpl userDao = new UserDAOImpl();
            if (!userDao.userExists(recipient)) {
                request.setAttribute("error", "Recipient College ID does not exist");
                request.getRequestDispatcher("compose.jsp").forward(request, response);
                return;
            }
        }

        // Create Mail object
        Mail mail = new Mail();
        mail.setSenderId(user.getCollegeId());
        mail.setRecipientId(recipient);
        mail.setSubject(subject);
        mail.setBody(body);

        try {
            MailDAOImpl mailDao = new MailDAOImpl();
            boolean success = false;

            // Save as draft or send
            if ("draft".equals(action)) {
                success = mailDao.saveDraft(mail); 
            } else if ("send".equals(action)) {
                success = mailDao.sendMail(mail);
            }

            // Redirect after success
            if (success) {
                String redirectPage = "draft".equals(action) ? "drafts.jsp" : "inbox.jsp";
                response.sendRedirect(redirectPage);
            } else {
                request.setAttribute("error", "Failed to save email");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error.jsp", "Database error: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}