package com.intranet.service;
import com.intranet.model.Mail;
import com.intranet.util.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MailDAOImpl {

    public List<Mail> getInbox(String collegeId) throws SQLException {
        List<Mail> inboxMails = new ArrayList<>();
        String sql = "SELECT id, sender_id, recipient_id, subject, body, is_read, is_important, sent_at " 
                   + "FROM mails WHERE recipient_id = ? ORDER BY sent_at DESC";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, collegeId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Mail mail = new Mail();
                // Map ALL columns to avoid null values
                mail.setId(rs.getInt("id"));
                mail.setSenderId(rs.getString("sender_id"));
                mail.setRecipientId(rs.getString("recipient_id"));
                mail.setSubject(rs.getString("subject"));
                mail.setBody(rs.getString("body"));
                mail.setRead(rs.getBoolean("is_read"));         // Correct method
                mail.setImportant(rs.getBoolean("is_important")); // Correct method
                mail.setSentAt(rs.getTimestamp("sent_at"));
                inboxMails.add(mail);
            }
        }
        return inboxMails;
    }

    public Mail getMailById(int mailId) throws SQLException {
    String sql = "SELECT * FROM mails WHERE id = ?";
    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setInt(1, mailId);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            Mail mail = new Mail();
            mail.setId(rs.getInt("id"));
            mail.setSenderId(rs.getString("sender_id"));
            mail.setRecipientId(rs.getString("recipient_id"));
            mail.setSubject(rs.getString("subject"));
            mail.setBody(rs.getString("body"));
            mail.setRead(rs.getBoolean("is_read"));        // Maps to `is_read` column
            mail.setImportant(rs.getBoolean("is_important")); // Maps to `is_important`
            mail.setSentAt(rs.getTimestamp("sent_at"));
            return mail;
        }
    }
    return null; // Return null if no mail found
}

    public boolean sendMail(Mail mail) throws SQLException {
    String sql = "INSERT INTO mails (sender_id, recipient_id, subject, body) VALUES (?, ?, ?, ?)";
    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, mail.getSenderId());
        stmt.setString(2, mail.getRecipientId());
        stmt.setString(3, mail.getSubject());
        stmt.setString(4, mail.getBody());
        
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    }
}

    // In MailDAOImpl.java
    public void markAsRead(int mailId) throws SQLException {
    String sql = "UPDATE mails SET is_read = true WHERE id = ?";
    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, mailId);
        stmt.executeUpdate();
    }
}

    public List<Mail> getSentMails(String senderId) throws SQLException {
    String sql = "SELECT * FROM mails WHERE sender_id = ? ORDER BY sent_at DESC";
    List<Mail> sentMails = new ArrayList<>();
    
    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, senderId);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Mail mail = new Mail();
            mail.setId(rs.getInt("id"));
            mail.setRecipientId(rs.getString("recipient_id"));
            mail.setSubject(rs.getString("subject"));
            mail.setBody(rs.getString("body"));
            mail.setSentAt(rs.getTimestamp("sent_at"));
            sentMails.add(mail);
        }
    }
    return sentMails;
}

    // Save as draft
public boolean saveDraft(Mail mail) throws SQLException {
    String sql = "INSERT INTO mails (sender_id, recipient_id, subject, body, status) "
               + "VALUES (?, ?, ?, ?, 'DRAFT')";
    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, mail.getSenderId());
        stmt.setString(2, mail.getRecipientId());
        stmt.setString(3, mail.getSubject());
        stmt.setString(4, mail.getBody());
        
        return stmt.executeUpdate() > 0;
    }
}

// Get all drafts for a user
public List<Mail> getDrafts(String senderId) throws SQLException {
    String sql = "SELECT * FROM mails WHERE sender_id = ? AND status = 'DRAFT'";
    List<Mail> drafts = new ArrayList<>();
    
    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, senderId);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Mail mail = mapResultSetToMail(rs); // Reuse your existing mapping
            drafts.add(mail);
        }
    }
    return drafts;
}

    private Mail mapResultSetToMail(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean deleteDraft(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean moveToTrash(int mailId) throws SQLException {
        String sql = "UPDATE mail SET trashed = true WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, mailId);
            return pstmt.executeUpdate() > 0;
        }
    }

    // Get all trashed emails for a user
    public List<Mail> getTrashedEmails(int userId) throws SQLException {
        String sql = "SELECT * FROM mail WHERE trashed = true AND (sender_id = ? OR receiver_id = ?)";
        // Implement similar to getInboxEmails()
        return null;
    }

    // Restore from trash
    public boolean restoreFromTrash(int mailId) throws SQLException {
        String sql = "UPDATE mail SET trashed = false WHERE id = ?";
        // Similar to moveToTrash()
        return false;
    }

    public boolean deleteMail(int mailId, int userId) throws SQLException {
        String sql = "DELETE FROM mails WHERE id = ? AND (sender_id = ? OR recipient_id = ?)";
        
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, mailId);
            stmt.setInt(2, userId);
            stmt.setInt(3, userId);
            
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        }
    }
}