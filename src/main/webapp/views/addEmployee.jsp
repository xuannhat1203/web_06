<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<h2>Add Employee</h2>
<form action="<%= request.getContextPath() %>/EmployeeController" method="post">
    <input type="text" name="name" placeholder="Name" required><br>
    <input type="date" name="birthday" required><br>
    <input type="text" name="phone" placeholder="Phone" required><br>
    <input type="email" name="email" placeholder="Email" required><br>
    <input type="number" step="0.01" name="salary" placeholder="Salary" required><br>
    <input type="text" name="position" placeholder="Position" required><br>
    <input type="hidden" name="action" value="addEmployee">
    <input type="submit" value="Add Employee">
</form>
</body>
</html>
