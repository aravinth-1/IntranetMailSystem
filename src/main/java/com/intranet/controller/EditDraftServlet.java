package com.intranet.controller;


import com.intranet.model.Mail;
import com.intranet.service.MailDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editdraft")
public class EditDraftServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String draftId = request.getParameter("id");
        try {
            Mail draft = new MailDAOImpl().getMailById(Integer.parseInt(draftId));
            request.setAttribute("draft", draft);
            request.getRequestDispatcher("compose.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("drafts?error=1");
        }
    }
}