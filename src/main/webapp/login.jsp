<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Intranet Mailing System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
    
        body {
            background-color: #0066cc;
            height: 100vh;
            display: flex;
            align-items: center;
            background-image: url('multi.jpg');
            
        }
        .login-container {
            max-width: 400px;
            margin: 0 auto;
            padding: 4rem;
            background: white;
            border-radius: 50px;
            box-shadow: 0 10px 10px rgba(0, 0, 0, 0.3);
        }
        .welcome-text {
            text-align: center;
            margin-bottom: 2rem;
            font-weight: 500;
            color: #2d3748;
        }
        .form-control {
            margin-bottom: 2rem;
            padding: 0.75rem 1rem;
            border: 2px solid black;
            border-radius: 6px;
        }
        .login-btn {
            width: 100%;
            padding: 0.75rem;
            background-color: #4299e1;
            border: none;
            font-weight: 500;
        }
        .register-link {
            text-align: center;
            margin-top: 1.5rem;
            color: black;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="login-container">
            <h2 class="welcome-text mb-4">Welcome Back 👋</h2>
            

            
            <form action="${pageContext.request.contextPath}/login" method="POST">
                <input type="text" 
                       class="form-control" 
                       name="collegeId"
                       placeholder="College ID" 
                       required>
                
                <input type="password" 
                       class="form-control" 
                       name="password"
                       placeholder="Password" 
                       required>
                
                <button type="submit" class="btn btn-primary login-btn">Login</button>
                
                <div class="register-link">
                    New here? <a href="register.jsp">Create an account</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>