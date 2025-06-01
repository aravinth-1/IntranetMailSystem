package com.intranet.dao;

import com.intranet.model.Mail;
import java.sql.SQLException;
import java.util.List;

public interface MailDAO {
    // Draft Operations
    boolean saveDraft(Mail draft) throws SQLException;
    boolean updateDraft(Mail draft) throws SQLException;
    List<Mail> getDrafts(String userId) throws SQLException;
    
    // Mail Operations
    boolean sendMail(Mail mail) throws SQLException;
    boolean deleteMail(int mailId, String userId) throws SQLException;
    List<Mail> getInbox(String userId) throws SQLException;
    List<Mail> getSentMails(String userId) throws SQLException;
    
    // Status Updates
    boolean markAsRead(int mailId) throws SQLException;
    boolean toggleImportant(int mailId) throws SQLException;
}