<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task Details</title>
</head>
<body>
<h2>Task Details</h2>
<p>ID: <c:out value="${task.id}"/></p>
<p>Title: <c:out value="${task.title}"/></p>
<p>Description: <c:out value="${task.description}"/></p>
<p>Author: <a href="/users/${task.user.username}"><c:out value="${task.user.username}"/></a></p>

<c:if test="${task.user.id == currentUserId || currentUserRole == 'ROLE_ADMIN'}">
    <a href="${pageContext.request.contextPath}/tasks/edit/${task.id}">Edit</a>
    <form action="${pageContext.request.contextPath}/tasks/delete/${task.id}" method="post" style="display:inline;">
        <button type="submit">Delete</button>
    </form>
</c:if>

<a href="${pageContext.request.contextPath}/tasks">Back to List</a>
</body>
</html>
