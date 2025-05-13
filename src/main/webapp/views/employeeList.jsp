
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
<h2>Employee List</h2>

<form action="EmployeeController" method="get">
    <input type="text" name="search" placeholder="Search by name or ID">
    <input type="submit" value="Search">
</form>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Salary</th>
        <th>Position</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.phone}</td>
            <td>${employee.email}</td>
            <td>${employee.salary}</td>
            <td>${employee.position}</td>
            <td>
                <form action="EmployeeController" method="get">
                    <input type="hidden" name="action" value="edit">
                    <input type="hidden" name="id" value="${employee.id}">
                    <input type="submit" value="Edit">
                </form>
                <form action="EmployeeController" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${employee.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="views/addEmployee.jsp">Add New Employee</a>

</body>
</html>
