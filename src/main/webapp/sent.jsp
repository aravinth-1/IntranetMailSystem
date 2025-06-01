<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Sent - Intranet Mailing System</title>
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
    padding: 2rem 2rem;
    text-align: center;
    box-shadow: 0 3px 6px rgba(0,0,0,0.12);
  }
  nav {
    background-color: #2a66c7;
    padding: 0.55rem 2rem;
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
    max-width: 900px;
    margin: 2rem auto;
    padding: 0 1rem;
  }
  table {
    width: 100%;
    border-collapse: collapse;
    background-color: white;
  }
  thead {
    background-color: #48c6ef;
    color: black;
  }
  th, td {
    padding: 1rem 1rem;
    text-align: left;
    border-bottom: 1px solid #999999;
    border-color: black;
  }
  tr:hover {
    
    cursor: pointer;
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
  <header>
    <h1>Sent - Intranet Mailing System</h1>
  </header>
  <nav>
    <a href="dashboard.jsp">Dashboard</a>
    <a href="compose.jsp">Compose</a>
    <a href="inbox">Inbox</a>
    <a href="sent" class="active">Sent</a>
    <a href="drafts">Draft</a>
    <a href="login.jsp" style="margin-left:auto;">Logout</a>
  </nav>
  <main>
    <table aria-label="Sent Items">
      <thead>
        <tr>
          <th>To</th>
          <th>Subject</th>
          <th>Date & Time</th>
        </tr>	
      </thead>
      <tbody id="sentMessages">
				<c:forEach items="${sentMails}" var="mail">
                    <tr>
                        <td>${mail.recipientId}</td>
                        <td><a href="viewmail?id=${mail.id}">${mail.subject}</a></td>
                        <td>${mail.sentAt}</td>
                    </tr>
                </c:forEach>
      </tbody>
    </table>
  </main>
  <footer>
    &copy; 2025 Intranet Mailing System
  </footer>
</body>
</html>
