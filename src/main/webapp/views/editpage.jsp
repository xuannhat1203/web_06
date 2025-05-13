<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cập nhật sách</title>
</head>
<body>
<h2 style="text-align: center;">Cập nhật thông tin sách</h2>
<form action="BookController" method="post" style="width: 400px; margin: auto;">
    <input type="hidden" name="action" value="update">
    <label for="id">Mã sách:</label><br>
    <input type="text" id="id" name="id" value="${book.id}" readonly><br><br>

    <label for="title">Tiêu đề:</label><br>
    <input type="text" id="title" name="title" value="${book.title}" required><br><br>

    <label for="author">Tác giả:</label><br>
    <input type="text" id="author" name="author" value="${book.author}" required><br><br>

    <label for="type">Thể loại:</label><br>
    <input type="text" id="type" name="type" value="${book.type}" required><br><br>

    <label for="quantity">Số lượng:</label><br>
    <input type="number" id="quantity" name="quantity" value="${book.quantity}" required><br><br>
    <input type="submit" value="Cập nhật">
</form>
</body>
</html>

