<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error | College Intranet</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
  body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    margin: 0;
    background-color: #e6f0ff;
    color: #222;
    background-image: url(multi.jpg);
  }
    header {
    background-color: #4a90e2;
    color: white;
    padding: 1.5rem 2rem;
    text-align: center;
    box-shadow: 0 3px 6px rgba(0,0,0,0.12);
    font-family: Trebuchet MS;
  }
    nav {
    background-color: #2a66c7;
    padding: 0.6rem 2rem;
    display: flex;
    gap: 1rem;
  }
  nav a {
    color: white;
    text-decoration: none;
    font-weight: 600;
    padding: 0.45rem 1rem;
    border-radius: 4px;
    transition: background-color 0.3s;
  }
  nav a:hover, nav a.active {
    background-color: #194a9e;
  }
  main {
    max-width: 800px;
    margin: 1rem auto;
    background-color: white;
    padding: 2rem;
    border-radius :10px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.1);
  }
  label {
    display: block;
    margin-bottom: 0.5rem;
    font-weight: bold;
    color: black;
  }
  input[type="text"], input[type="email"], textarea {
    width: 96%;
    padding: 0.6rem 0.8rem;
    margin-bottom: 1.2rem;
    border-radius: 4px;
    border: 1.8px solid #999999;
    font-size: 1rem;
    transition: border-color 0.3s;
  }
  input:focus, textarea:focus {
    outline: none;
    border-color: #48c6ef;
  }
  textarea {
    min-height: 150px;
    resize: vertical;
  }
  button {
    background-color: #0099ff;
    color: white;
    border: none;
    padding: 0.8rem 2rem;
    border-radius: 4px;
    font-size: 1.1rem;
    cursor: pointer;
    transition: background-color 0.3s;
    margin-right: 0.5rem;
  }
  button:hover {
    background-color: #2a9df4;
  }
        .error-container {
            max-width: 800px;
            margin: 50px auto;
            padding: 30px;
            border-radius: 10px;
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
        }
    </style>
</head>
<body>
  <nav>
      <a class="nav-link" href="dashboard.jsp">Dashboard</a>
                <a class="nav-link active" href="compose.jsp">Compose</a>
                <a class="nav-link" href="inbox">Inbox</a>
                <a class="nav-link" href="sent">Sent</a>
                <a href="drafts" class="list-group-item list-group-item-action">Draft</a>
                <a href="login.jsp" style="margin-left:auto;">Logout</a>
  </nav>

    
    <div class="container">
        <div class="error-container">
            <h2 class="text-danger mb-4">⚠️ Oops! Something went wrong</h2>
            
            <!-- Display Error Message -->
            <c:if test="${not empty requestScope.error}">
                <div class="alert alert-danger">
                    <strong>Error Details:</strong> ${requestScope.error}
                </div>
            </c:if>
            
            <c:if test="${not empty param.msg}">
                <div class="alert alert-danger">
                    <strong>Error Details:</strong> ${param.msg}
                </div>
            </c:if>

            <!-- Generic Troubleshooting -->
            <div class="mt-4">
                <h5>What you can do:</h5>
                <ul>
                    <li>Check if you entered information correctly</li>
                    <li>Try again after some time</li>
                    <li>Contact system administrator</li>
                </ul>
                
                <div class="mt-3">
                    <a href="dashboard.jsp" class="btn btn-primary">Return to Dashboard</a>
                    <a href="login.jsp" class="btn btn-outline-secondary">Back to Login</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>