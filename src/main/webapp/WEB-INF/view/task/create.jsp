<!DOCTYPE html>
<html>
<head>
    <title>Create Task</title>
</head>
<body>
<h2>Create New Task</h2>
<form action="${pageContext.request.contextPath}/tasks/create" method="post">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required="required"/>
    <label for="description">Description:</label>
    <textarea id="description" name="description" required="required"></textarea>
    <button type="submit">Create Task</button>
</form>
<a href="${pageContext.request.contextPath}/tasks">Back to List</a>
</body>
</html>
