package com.intranet.controller;
import com.intranet.service.MailDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletedraft")
public class DeleteDraftServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String draftId = request.getParameter("id");
        try {
            boolean success = new MailDAOImpl().deleteDraft(Integer.parseInt(draftId));
            response.sendRedirect("drafts?" + (success ? "success=1" : "error=1"));
        } catch (Exception e) {
            response.sendRedirect("drafts?error=1");
        }
    }
}