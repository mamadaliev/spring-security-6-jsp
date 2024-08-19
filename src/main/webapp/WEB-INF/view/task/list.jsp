<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tasks</title>
</head>
<body>
<h2>Tasks</h2>
<table border="1px">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Author</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="task" items="${tasks}">
        <tr>
            <td><fmt:formatNumber value="${task.id}"/></td>
            <td><c:out value="${task.title}"/></td>
            <td><c:out value="${task.description}"/></td>
            <td><c:out value="${task.user.username}"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/tasks/${task.id}">View</a>
                <c:if test="${task.user.id == currentUserId || 'ROLE_ADMIN' == currentUserRole}">
                    <a href="${pageContext.request.contextPath}/tasks/edit/${task.id}">Edit</a>
                    <form action="${pageContext.request.contextPath}/tasks/delete/${task.id}" method="post"
                          style="display:inline;">
                        <button type="submit">Delete</button>
                    </form>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
- <a href="${pageContext.request.contextPath}/tasks/create">Create New Task</a><br/>
- <a href="${pageContext.request.contextPath}/">Back to Home</a><br>
</body>
</html>
