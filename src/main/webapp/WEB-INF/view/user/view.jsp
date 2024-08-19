<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>${user.username} - User Details</title>
</head>
<body>
<h2>User Details</h2>
<p>ID: <c:out value="${user.id}"/></p>
<p>Username: <c:out value="${user.username}"/></p>
<p>Role: <c:out value="${user.role}"/></p>
<p>Tasks Count: <c:out value="${taskCount}"/></p>

<a href="${pageContext.request.contextPath}/users">Back to Users</a>
</body>
</html>
