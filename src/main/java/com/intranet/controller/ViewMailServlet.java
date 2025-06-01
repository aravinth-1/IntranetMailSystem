package com.intranet.controller;

import com.intranet.model.Mail;
import com.intranet.service.MailDAOImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/viewmail")
public class ViewMailServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String mailIdParam = request.getParameter("id");
        if (mailIdParam == null || mailIdParam.isEmpty()) {
            response.sendRedirect("inbox?error=missing_id");
            return;
        }

        try {
            int mailId = Integer.parseInt(mailIdParam);
            MailDAOImpl mailDao = new MailDAOImpl();
            Mail mail = mailDao.getMailById(mailId);

            if (mail == null) {
                response.sendRedirect("inbox?error=mail_not_found");
                return;
            }

            // Mark email as read
            mailDao.markAsRead(mailId); // Implement this method (see Step 3)

            request.setAttribute("mail", mail);
            request.getRequestDispatcher("/viewmail.jsp").forward(request, response);
            
        } catch (NumberFormatException e) {
            response.sendRedirect("inbox?error=invalid_id");
        } catch (SQLException e) {
            response.sendRedirect("inbox?error=database_error");
        }
    }
}