package com.intranet.controller;

import com.intranet.model.Mail;
import com.intranet.model.User;
import com.intranet.service.MailDAOImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/sent")
public class SentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        MailDAOImpl mailDao = new MailDAOImpl();
        List<Mail> sentMails = null;
        try {
            sentMails = mailDao.getSentMails(user.getCollegeId());
        } catch (SQLException ex) {
            Logger.getLogger(SentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("sentMails", sentMails);
        request.getRequestDispatcher("/sent.jsp").forward(request, response);
    }
}