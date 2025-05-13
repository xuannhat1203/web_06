
package com.baitap.session06.controller;

import com.baitap.session06.modal.Product;
import com.baitap.session06.dao.ProductCartDaoImp;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CartController", value = "/CartController")
public class CartController extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int userId = 1; // giả định userId cố định
        ProductCartDaoImp cartDao = new ProductCartDaoImp();
        List<Product> cartItems = cartDao.getCartItems(userId);
        request.setAttribute("cartItems", cartItems);
        request.getRequestDispatcher("views/carts.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if ("remove".equals(action)) {
            int cartId = Integer.parseInt(request.getParameter("cartId"));
            ProductCartDaoImp cartDao = new ProductCartDaoImp();
            cartDao.removeFromCart(cartId);
        }
        response.sendRedirect("CartController");
    }

    public void destroy() {
    }
}
