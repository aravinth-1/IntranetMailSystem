package com.intranet.controller;
import com.intranet.dao.UserDAO;
import com.intranet.model.User;
import com.intranet.service.UserDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String collegeId = request.getParameter("collegeId");
    String password = request.getParameter("password");

    System.out.println("Login attempt - CollegeID: " + collegeId); // Debug log
        
        try {
            UserDAO userDao = new UserDAOImpl();
            User user = userDao.validateUser(collegeId, password);
            
            if (user != null) {
                System.out.println("User found: " + user.getName()); // Debug log
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("dashboard.jsp");
            } else {
                System.out.println("Validation failed for: " + collegeId); // Debug log
                request.setAttribute("error", "Invalid credentials");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.err.println("Login error: " + e.getMessage()); // Error log
            request.setAttribute("error", "System error: " + e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
