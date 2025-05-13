
package com.baitap.session06.controller;

import com.baitap.session06.modal.User;
import com.baitap.session06.service.UserServiceImp;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    public static UserServiceImp userService = new UserServiceImp();
    private String message;

    public void init() {
        message = "Hello World!";
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.getUserById(username, password);
        if (user != null) {
            request.setAttribute("username", username);
            request.getRequestDispatcher("views/result.jsp").forward(request,response);
        } else {
            request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
