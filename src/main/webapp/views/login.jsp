<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Đăng nhập</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
    }
    .form-container {
      width: 350px;
      margin: 100px auto;
      padding: 25px;
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 0 8px rgba(0,0,0,0.2);
    }
    .form-container h2 {
      text-align: center;
    }
    input[type="text"], input[type="password"] {
      width: 100%;
      padding: 10px;
      margin: 8px 0 16px 0;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    button {
      width: 100%;
      padding: 10px;
      background-color: #0288d1;
      color: white;
      border: none;
      border-radius: 4px;
      font-size: 16px;
    }
    a {
      display: block;
      text-align: center;
      margin-top: 15px;
      color: #0288d1;
      text-decoration: none;
    }
  </style>
</head>
<body>
<div class="form-container">
  <h2>Đăng nhập</h2>
  <form action="<%= request.getContextPath() %>/LoginController" method="post">
  <label>Tên đăng nhập</label>
    <input type="text" name="username" required>

    <label>Mật khẩu</label>
    <input type="password" name="password" required>

    <button type="submit">Đăng nhập</button>
    <a href="register.jsp">Chưa có tài khoản? Đăng ký</a>
  </form>
</div>
</body>
</html>
