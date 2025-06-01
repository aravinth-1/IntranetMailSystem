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

@WebServlet("/drafts")
public class DraftsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<Mail> drafts = null;
        try {
            drafts = new MailDAOImpl().getDrafts(user.getCollegeId());
        } catch (SQLException ex) {
            Logger.getLogger(DraftsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("drafts", drafts);
        request.getRequestDispatcher("drafts.jsp").forward(request, response);
    }
}