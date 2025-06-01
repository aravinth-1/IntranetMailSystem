package com.intranet.model;

import java.sql.Timestamp;

public class Mail {
    private int id;
    private String senderId;
    private String recipientId;
    private String subject;
    private String body;
    private boolean isRead;       // Matches `is_read` column
    private boolean isImportant;  // Matches `is_important` column
    private Timestamp sentAt;
    private String status;  // DRAFT or SENT
    private boolean trashed;
    private String email;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getSenderId() { return senderId; }
    public void setSenderId(String senderId) { this.senderId = senderId; }

    public String getRecipientId() { return recipientId; }
    public void setRecipientId(String recipientId) { this.recipientId = recipientId; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    // Boolean getters must be "isXxx()" for JSP EL
    public boolean isRead() { return isRead; }          // Critical for `${mail.read}`
    public void setRead(boolean read) { isRead = read; }

    public boolean isImportant() { return isImportant; } // Critical for `${mail.important}`
    public void setImportant(boolean important) { isImportant = important; }

    public Timestamp getSentAt() { return sentAt; }
    public void setSentAt(Timestamp sentAt) { this.sentAt = sentAt; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public boolean isTrashed() { return trashed; }
    public void setTrashed(boolean trashed) { this.trashed = trashed; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
}