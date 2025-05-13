package com.baitap.session06.dao;

import com.baitap.session06.modal.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBook(int page, int size);
    boolean addBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(Book book);
    List<Book> filterBook(String keyword);
}
