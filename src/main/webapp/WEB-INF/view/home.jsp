<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<div>
    <c:if test="${not empty username}">
        Welcome, ${username}!
    </c:if>
    <c:if test="${empty username}">
        Welcome, Guest!
    </c:if>
    <br/>
    - <a href="${pageContext.request.contextPath}/tasks">Tasks</a> (private)
    <br/>
    - <a href="${pageContext.request.contextPath}/users">Users</a> (public)
    <br/>
    <c:if test="${not empty username}">
        - <a href="${pageContext.request.contextPath}/users/${username}">Account</a>
        <br/>
    - <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </c:if>
</div>
</body>
</html>
