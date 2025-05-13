
package com.baitap.session06.controller;

import com.baitap.session06.modal.Product;
import com.baitap.session06.service.ProductServiceImp;
import com.baitap.session06.dao.ProductCartDaoImp;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {
    public static ProductServiceImp productServiceImp = new ProductServiceImp();
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Product> listProduct = productServiceImp.getProducts();
        request.setAttribute("products", listProduct);
        request.getRequestDispatcher("views/listProduct.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int userId = 1; // giả định userId cố định, bạn có thể lấy từ session

        ProductCartDaoImp cartDao = new ProductCartDaoImp();
        cartDao.addToCart(userId, productId, quantity);

        response.sendRedirect("CartController");
    }

    public void destroy() {
    }
}
