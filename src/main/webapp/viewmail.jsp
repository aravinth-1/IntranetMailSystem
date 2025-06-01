<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>${mail.subject}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <style>
        :root {
            --primary-color: #48c6ef;
            --secondary-color: #2a9df4;
            --accent-color: #e3f2fd;
        }
        
        body {
            background-color: #e6f0ff;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-image: url(multi.jpg);
            
        }
 
        .mail-card {
            max-width: 800px;
            margin: 7rem auto;
            border: none;
            border-radius: 6px;
            box-shadow: 0 28px 40px rgba(0,0,0,0.7);
        }
        
        .mail-header {
            background-color: #4a90e2;
            color: white;
            border-radius: 12px 12px 0 0;
            padding: 1.2rem 2rem;
        }
        
        .mail-title {
            font-size: 2rem;
            font-weight: 600;
            margin-bottom: 0.5rem;
        }
        
        .mail-meta {
            display: grid;
            gap: 0.5rem;
            font-size: 0.95rem;
        }
        
        .meta-item {
            display: flex;
            align-items: center;
            gap: 0.8rem;
        }
        
        .mail-body {
            padding: 4rem;
            background-color: white;
            line-height: 1.7;
            white-space: pre-wrap;
            font-size: 1.1rem;
            color: black;
        }
        
        .action-buttons {
            background-color: white;
            padding: 1.5rem 2rem;
            border-radius: 0 0 12px 12px;
            border-top: 2px solid #4a90e2;
            display: flex;
            gap: 2rem;
        }
        
          footer {
    text-align: center;
    padding: 1rem;
    font-size: 0.8rem;
    color: white;
  }
    </style>
</head>
<body>

    
    <div class="container">

        <c:choose>
            <c:when test="${not empty mail}">
                <div class="card mail-card">
                    <div class="card-header mail-header">
                        <h2 class="mail-title">${mail.subject}</h2>
                        <div class="mail-meta">
                            <div class="meta-item">
                                <i class="fas fa-user fa-fw"></i>
                                <span><strong>From:</strong> ${mail.senderId}</span>
                            </div>
                            <div class="meta-item">
                                <i class="fas fa-users fa-fw"></i>
                                <span><strong>To:</strong> ${mail.recipientId}</span>
                            </div>
                            <div class="meta-item">
                                <i class="fas fa-clock fa-fw"></i>
                                <span><strong>Date:</strong> 
                                    <fmt:formatDate value="${mail.sentAt}" pattern="dd MMM yyyy, hh:mm a" />
                                </span>
                            </div>
                        </div>
                    </div>
                    
                    <div class="card-body mail-body">
                        ${mail.body}
                    </div>
                    
                    <div class="card-footer action-buttons">
                        
                        <a href="inbox" class="btn btn-primary">
                            <i class="fas fa-inbox me-2"></i>Back to Inbox
                        </a>
                        
                        <a href="compose.jsp" class="btn btn-outline-secondary">
                            <i class="fas fa-reply me-2"></i>Reply
                        </a>
                            
                        <form id="deleteForm" action="${pageContext.request.contextPath}/DeleteMailServlet" method="POST">
                            <input type="hidden" name="mailId" value="${mail.id}">
                            
                            <button type="button" class="btn btn-danger" onclick="confirmDelete()">
                                <i class="fas fa-trash-alt me-2"></i>Delete
                            </button>
                        </form>
                            
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="alert alert-danger mt-4">
                    <i class="fas fa-exclamation-circle me-2"></i>
                    Mail not found or invalid mail ID
                </div>
            </c:otherwise>
        </c:choose>
    </div>

    <script>
        function confirmDelete() {
            if(confirm('Are you sure you want to permanently delete this message?')) {
                // Submit the form with mail ID
                document.getElementById('deleteForm').submit();
            }
        }
    </script>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
           <footer>
    &copy; 2025 Intranet Mailing System
  </footer>
</body>
</html>