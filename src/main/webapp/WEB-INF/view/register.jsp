<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h2>Register</h2>
<c:if test="${param.error}">
    <p style="color:red;">Invalid username or password.</p>
</c:if>
<form action="${pageContext.request.contextPath}/register" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required="required"/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required="required"/>
    <button type="submit">Register</button>
</form>
<a href="${pageContext.request.contextPath}/login">Login</a>
</body>
</html>
