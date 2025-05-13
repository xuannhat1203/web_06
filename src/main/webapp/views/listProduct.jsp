
<%@ page import="com.baitap.session06.modal.Product" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sản phẩm</title>
    <style>
        .product {
            border: 1px solid #ccc;
            padding: 12px;
            margin: 10px;
            display: inline-block;
            width: 220px;
            vertical-align: top;
            text-align: center;
        }
        img {
            width: 180px;
            height: 180px;
            object-fit: cover;
        }
        button {
            margin-top: 10px;
            padding: 6px 12px;
        }
    </style>
</head>
<body>
<h2>Danh sách sản phẩm</h2>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    if (products != null && !products.isEmpty()) {
        for (Product p : products) {
%>
<div class="product">
    <img src="<%= p.getImageUrl() %>" alt="Ảnh sản phẩm">
    <h3><%= p.getName() %></h3>
    <p>Giá: <%= String.format("%,.0f", p.getPrice()) %> VNĐ</p>
    <form action="ProductController" method="post">
        <input type="hidden" name="productId" value="<%= p.getId() %>">
        <input type="number" name="quantity" value="1" min="1" max="100" required>
        <button type="submit">Thêm vào giỏ</button>
    </form>
</div>
<%
    }
} else {
%>
<p>Không có sản phẩm nào.</p>
<%
    }
%>
</body>
</html>
