package com.baitap.session06.service;

import com.baitap.session06.modal.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBook(int page, int size);
    boolean addBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(Book book);
    List<Book> filterBook(String keyword);
}
