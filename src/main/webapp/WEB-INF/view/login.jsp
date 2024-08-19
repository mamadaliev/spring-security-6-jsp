<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<c:if test="${param.error}">
    <p style="color:red;">Invalid username or password.</p>
</c:if>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required="required"/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required="required"/>
    <button type="submit">Login</button>
</form>
<a href="${pageContext.request.contextPath}/register">Register</a>
</body>
</html>
