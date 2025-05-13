<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Danh sách sách</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 12px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        caption {
            font-size: 24px;
            margin-bottom: 10px;
        }

        .search-form {
            width: 90%;
            margin: 20px auto;
            text-align: right;
        }

        .search-form input[type="text"] {
            padding: 8px;
            width: 250px;
            font-size: 16px;
        }

        .search-form input[type="submit"] {
            padding: 8px 16px;
            font-size: 16px;
            margin-left: 10px;
            cursor: pointer;
        }

        .pagination {
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 20px;
            gap: 15px;
        }

        .page-number {
            font-size: 18px;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="search-form">
    <form action="BookController" method="get">
        <input type="hidden" name="action" value="search">
        <input type="text" name="keyword" placeholder="Tìm kiếm sách..." value="${param.keyword}">
        <input type="submit" value="Tìm kiếm">
    </form>
</div>

<table>
    <caption>Danh sách sách</caption>
    <thead>
    <tr>
        <th>Mã sách</th>
        <th>Tiêu đề</th>
        <th>Tác giả</th>
        <th>Thể loại</th>
        <th>Số lượng</th>
        <th rowspan="2">Hành động</th>
    </tr>
    </thead>
    <tbody id="book-table-body">
    <c:forEach var="item" items = "${books}">
        <tr>
            <td>${item.id}</td>
            <td>${item.title}</td>
            <td>${item.author}</td>
            <td>${item.type}</td>
            <td>${item.quantity}</td>
            <td>
                <form action="BookController" method="get">
                    <input type="hidden" name="action" value="edit">
                    <input type="hidden" name="idEdit" value="${item.id}">
                    <input type="submit" value="Edit">
                </form>
                <form action="BookController" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="idDelete" value="${item.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="pagination">
    <form action="BookController" method="get">
        <input type="hidden" name="action" value="prev">
        <input type="hidden" name="page" value="${currentPage}">
        <input type="submit" value="Prev">
    </form>
    <span class="page-number" id="current-page">${currentPage}</span>
    <form action="BookController" method="get">
        <input type="hidden" name="action" value="next">
        <input type="hidden" name="page" value="${currentPage}">
        <input type="submit" value="Next">
    </form>
</div>

</body>
</html>
