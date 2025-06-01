<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Inbox - Intranet Mailing System</title>
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
    background-color: #f1faff;
    cursor: pointer;
  }
  .unread {
    font-weight: bold;
    background-color: #e3f2fd;
  }
  .status-badge {
    font-weight: 600;
    padding: 0.25rem 0.6rem;
    border-radius: 12px;
    font-size: 0.85rem;
    display: inline-block;
    color: white;
  }
  .status-read {
    background-color: #6c757d;
  }
  .status-unread {
    background-color: #007bff;
  }
  .status-replied {
    background-color: #28a745;
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
      <h1> Inbox - Intranet Mailing System </h1>
  </header>
    <nav>
        <a href="dashboard.jsp">Dashboard</a>
        <a href="compose.jsp">Compose</a>
        <a href="inbox" class="active">Inbox</a>
        <a href="sent">Sent</a>
        <a href="drafts">Draft</a>
        <a href="login.jsp" style="margin-left: auto;">Logout</a>
    </nav>
    <c:if test="${not empty success}">
    <div class="alert alert-success">${success}</div>
</c:if>

  <main>
    <table aria-label="Inbox Messages">
      <thead>
        <tr>
          <th>From</th>
          <th>Subject</th>
          <th>Status</th>
          <th>Date & Time</th>
        </tr>
      </thead>
      <tbody id="messagesList">
        <c:forEach items="${inboxMails}" var="mail">
                    <tr>
                        <td>${mail.senderId}</td>
                        <td><a href="viewmail?id=${mail.id}">${mail.subject}</a></td>
                        <td>
                            <c:choose>
                                <c:when test="${mail.read}">✔️ Read</c:when>
                                <c:otherwise>🕒 Unread</c:otherwise>
                            </c:choose>
                        </td>
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

