package com.intranet.controller;

import com.intranet.model.User;
import com.intranet.service.UserDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get parameters
        String collegeId = request.getParameter("collegeId");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String confirmPassword = request.getParameter("confirmPassword");
        
        // Validate passwords match
        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Passwords do not match");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        
        // Create user object
        User user = new User();
        user.setName(name);
        user.setCollegeId(collegeId);
        user.setPassword(password); // Note: Hash this in production
        user.setEmail(email);
        
        // Save to database
        UserDAOImpl userDao = new UserDAOImpl();
        boolean isRegistered = userDao.registerUser(user);
        
        if (isRegistered) {
            response.sendRedirect("login.jsp?success=1");
        } else {
            request.setAttribute("error", "Registration failed. College ID may already exist.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}