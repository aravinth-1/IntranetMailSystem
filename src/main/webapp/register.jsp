<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register - Intranet Mailing System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #9933ff;
            height: 100vh;
            display: flex;
            align-items: center;
            background-image: url('multi.jpg');
        }
        .register-container {
            max-width: 400px;
            margin: 0 auto;
            padding: 2rem;
            background: white;
            border-radius: 40px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .register-title {
            text-align: center;
            margin-bottom: 2rem;
            font-weight: 500;
            color: #2d3748;
        }
        .form-control {
            margin-bottom: 1.5rem;
            padding: 0.75rem 1rem;
            border: 2px solid black;
            border-radius: 6px;
        }
        .register-btn {
            width: 100%;
            padding: 0.75rem;
            background-color: #4299e1;
            border: none;
            font-weight: 500;
        }
        .login-link {
            text-align: center;
            margin-top: 1.5rem;
            color: #718096;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="register-container">
            <h2 class="register-title mb-4">Create Your Account ✍</h2>
            

            <form action="${pageContext.request.contextPath}/register" method="POST">
                <input type="text" 
                       class="form-control" 
                       name="collegeId"
                       placeholder="College ID" 
                       required>
                
                <input type="text" 
                       class="form-control" 
                       name="name"
                       placeholder="Full Name" 
                       required>
                
                <input type="email" 
                       class="form-control" 
                       name="email"
                       placeholder="Email ID" 
                       required>
                
                <input type="password" 
                       class="form-control" 
                       name="password"
                       placeholder="Password" 
                       required>
                
                <input type="password" 
                       class="form-control" 
                       name="confirmPassword"
                       placeholder="Confirm Password" 
                       required>
                
                <button type="submit" class="btn btn-primary register-btn">Register</button>
                
                <div class="login-link">
                    Already have an account? <a href="login.jsp">Login here</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>