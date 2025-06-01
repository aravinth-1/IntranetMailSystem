package com.intranet.controller;
import com.intranet.model.User;
import com.intranet.service.MailDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DeleteMailServlet")
public class DeleteMailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if(user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            int mailId = Integer.parseInt(request.getParameter("mailId"));
            MailDAOImpl mailDao = new MailDAOImpl();
            
            if(mailDao.deleteMail(mailId, user.getId())) {
                session.setAttribute("success", "Message deleted successfully");
            } else {
                session.setAttribute("error", "Deletion failed. Message not found or no permission.");
            }
            
        } catch (NumberFormatException e) {
            session.setAttribute("error", "Invalid message ID format");
            e.printStackTrace();
        } catch (Exception e) {
            session.setAttribute("error", "Error deleting message: " + e.getMessage());
            e.printStackTrace();
        }
        
        response.sendRedirect("inbox");
    }
}