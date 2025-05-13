package com.baitap.session06.controller;

import com.baitap.session06.modal.Book;
import com.baitap.session06.service.BookServiceImp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "BookController", value = "/BookController")
public class BookController extends HttpServlet {
    private BookServiceImp bookServiceImp = new BookServiceImp();
    public static List<Book> listBook = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String pageParam = request.getParameter("page");
        int page = 1;
        int size = 5;
        if (pageParam != null) {
            try {
                page = Integer.parseInt(pageParam);
                if (page < 1) page = 1;
            } catch (NumberFormatException e) {
                page = 1;
            }
        }
        if (action != null) {
            if ("prev".equals(action) && page > 1) {
                page--;
            } else if ("next".equals(action)) {
                page++;
            }
        }

        listBook = bookServiceImp.getAllBook(page, size);
        if ((listBook == null || listBook.isEmpty()) && page > 1 && "next".equals(action)) {
            page--;
            listBook = bookServiceImp.getAllBook(page, size);
        }
        if (listBook == null) {
            listBook = new ArrayList<>();
        }
        if (action != null) {
            if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("idEdit"));
                Optional<Book> isCheck = listBook.stream().filter(b->b.getId() == id).findFirst();
                if (isCheck.isPresent()) {
                    request.setAttribute("book", isCheck.get());
                    request.getRequestDispatcher("views/editpage.jsp").forward(request, response);
                }
            }else if ("search".equals(action)) {
                String keyword = request.getParameter("keyword");
                List<Book> filteredBooks = bookServiceImp.filterBook(keyword);
                request.setAttribute("books", filteredBooks);
                request.setAttribute("keyword", keyword);
                request.getRequestDispatcher("views/listBooks.jsp").forward(request, response);
            }

        }
        request.setAttribute("books", listBook);
        request.setAttribute("currentPage", page);
        request.getRequestDispatcher("views/listBooks.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("idDelete"));
                Optional<Book> isCheck = listBook.stream().filter(b -> b.getId() == id).findFirst();
                isCheck.ifPresent(book -> bookServiceImp.deleteBook(book));
                response.sendRedirect("BookController?page=1");
        }else if ("update".equals(action)) {
                Book book = new Book();
                book.setId(Integer.parseInt(request.getParameter("id")));
                book.setTitle(request.getParameter("title"));
                book.setAuthor(request.getParameter("author"));
                book.setType(request.getParameter("type"));
                book.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                boolean success = bookServiceImp.updateBook(book);
                if (success) {
                    response.sendRedirect("BookController?page=1");
                } else {
                    request.setAttribute("message", "Cập nhật thất bại!");
                    request.setAttribute("book", book);
                    request.getRequestDispatcher("editBook.jsp").forward(request, response);
                }
            }
        }
    }

}

