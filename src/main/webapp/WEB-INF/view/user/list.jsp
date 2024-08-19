<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h2>Users</h2>
<table border="1px">
    <thead>
    <tr>
        <th>ID</th>
        <th>Username</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td><fmt:formatNumber value="${user.id}"/></td>
            <td><a href="/users/${user.username}"><c:out value="${user.username}"/></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
- <a href="${pageContext.request.contextPath}/">Back to Home</a><br>
</body>
</html>
