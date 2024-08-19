<!DOCTYPE html>
<html>
<head>
    <title>Edit Task</title>
</head>
<body>
<h2>Edit Task</h2>
<form action="${pageContext.request.contextPath}/tasks/edit/${task.id}" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" value="${task.title}" required="required"/>
    <label for="description">Description:</label>
    <textarea id="description" name="description" required="required">${task.description}</textarea>
    <button type="submit">Update Task</button>
</form>
<a href="${pageContext.request.contextPath}/tasks/${task.id}">Back to Task</a>
</body>
</html>
