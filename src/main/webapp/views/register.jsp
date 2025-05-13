<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e3f2fd;
        }
        .form-container {
            width: 400px;
            margin: 50px auto;
            padding: 25px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
        }
        .form-container h2 {
            text-align: center;
        }
        input[type="text"], input[type="password"], input[type="email"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0 16px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #388e3c;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 15px;
            color: #388e3c;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Đăng ký tài khoản</h2>
    <form action="<%= request.getContextPath() %>/RegisterController" method="post">
    <label>Tên đăng nhập</label>
        <input type="text" name="username" required>

        <label>Mật khẩu</label>
        <input type="password" name="password" required>

        <label>Email</label>
        <input type="email" name="email" required>

        <label>Số điện thoại</label>
        <input type="text" name="phone" required>

        <button type="submit">Đăng ký</button>

        <a href="login.jsp">Đã có tài khoản? Đăng nhập</a>
    </form>
</div>
</body>
</html>
