<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
<h2>Update Employee</h2>
<form action="EmployeeController" method="post">
    <input type="hidden" name="id" value="${idE}">
    <input type="text" name="name" value="${employee.name}" required><br>
    <input type="date" name="birthday" value="${employee.birthday}" required><br>
    <input type="text" name="phone" value="${employee.phone}" required><br>
    <input type="email" name="email" value="${employee.email}" required><br>
    <input type="number" step="0.01" name="salary" value="${employee.salary}" required><br>
    <input type="text" name="position" value="${employee.position}" required><br>
    <input type="hidden" name="action" value="update">
    <input type="submit" value="Update Employee">
</form>
</body>
</html>
