
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ Hàng</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Giỏ Hàng của bạn</h1>
<c:if test="${empty cartItems}">
    <p>Giỏ hàng của bạn đang trống.</p>
</c:if>
<c:if test="${not empty cartItems}">
    <table border="1">
        <thead>
        <tr>
            <th>Sản phẩm</th>
            <th>Số lượng</th>
            <th>Giá</th>
            <th>Tổng tiền</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${cartItems}">
            <tr>
                <td>${item.name}</td>
                <td>${item.quantity}</td>
                <td>${item.price}</td>
                <td>${item.quantity * item.price}</td>
                <td>
                    <!-- Form xóa sản phẩm -->
                    <form action="CartController" method="post">
                        <input type="hidden" name="action" value="remove">
                        <input type="hidden" name="cartId" value="${item.id}">
                        <button type="submit">Xóa</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:set var="total" value="0" />
    <c:forEach var="item" items="${cartItems}">
        <c:set var="total" value="${total + (item.quantity * item.price)}" />
    </c:forEach>
    <h3>Tổng tiền: ${total}</h3>
</c:if>
<a href="listProduct.jsp">Tiếp tục mua sắm</a>
</body>
</html>
