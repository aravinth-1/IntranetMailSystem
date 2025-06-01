package com.intranet.controller;

import com.intranet.model.Mail;
import com.intranet.model.User;
import com.intranet.service.MailDAOImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/inbox")
public class InboxServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            MailDAOImpl mailDao = new MailDAOImpl();
            List<Mail> inboxMails = mailDao.getInbox(user.getCollegeId());
            
            // Verify data before forwarding
            if (inboxMails == null) {
                throw new ServletException("Inbox data is null");
            }
            
            request.setAttribute("inboxMails", inboxMails);
            request.getRequestDispatcher("/inbox.jsp").forward(request, response);
            
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?msg=Database error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?msg=Unexpected error: " + e.getMessage());
        }
    }
}