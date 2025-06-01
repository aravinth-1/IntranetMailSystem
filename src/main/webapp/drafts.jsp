<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Drafts</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <div class="container mt-4">
        <h2>Drafts</h2>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>To</th>
                    <th>Subject</th>
                    <th>Last Saved</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${drafts}" var="draft">
                    <tr>
                        <td>${draft.recipientId}</td>
                        <td><a href="editdraft?id=${draft.id}">${draft.subject}</a></td>
                        <td>${draft.sentAt}</td>
                        <td>
                            <a href="editdraft?id=${draft.id}" class="btn btn-sm btn-warning">Edit</a>
                            <a href="deletedraft?id=${draft.id}" class="btn btn-sm btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>