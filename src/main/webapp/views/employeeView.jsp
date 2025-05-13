
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>
<h2>Employee Details</h2>
<p>ID: ${employee.id}</p>
<p>Name: ${employee.name}</p>
<p>Birthday: ${employee.birthday}</p>
<p>Phone: ${employee.phone}</p>
<p>Email: ${employee.email}</p>
<p>Salary: ${employee.salary}</p>
<p>Position: ${employee.position}</p>
<a href="views/employeeList.jsp">Back to Employee List</a>
</body>
</html>
