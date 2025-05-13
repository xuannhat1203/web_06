
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Form</title>
</head>
<body>
<h2>${employee == null ? 'Add New Employee' : 'Update Employee'}</h2>
<form action="EmployeeController?action=create" method="post">
    <input type="hidden" name="id" value="${employee.id}">
    <input type="text" name="name" value="${employee.name}" placeholder="Name" required><br>
    <input type="date" name="birthday" value="${employee.birthday}" placeholder="Birthday" required><br>
    <input type="text" name="phone" value="${employee.phone}" placeholder="Phone" required><br>
    <input type="email" name="email" value="${employee.email}" placeholder="Email" required><br>
    <input type="number" step="0.01" name="salary" value="${employee.salary}" placeholder="Salary" required><br>
    <input type="text" name="position" value="${employee.position}" placeholder="Position" required><br>
    <input type="submit" value="${employee == null ? 'Add Employee' : 'Update Employee'}">
</form>
</body>
</html>
