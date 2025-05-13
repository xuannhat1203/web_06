<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trò Chơi Oẳn Tù Tì</title>
</head>
<body>
<h1>Trò Chơi Oẳn Tù Tì</h1>
<form action="GameServlet" method="post">
    <h3>Lựa Chọn Của Bạn:</h3>
    <input type="radio" name="choice" value="Búa" required> Búa
    <input type="radio" name="choice" value="Kéo"> Kéo
    <input type="radio" name="choice" value="Lá"> Lá
    <br><br>
    <input type="submit" value="Chơi">
</form>
</body>
</html>
