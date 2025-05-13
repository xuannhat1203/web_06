package com.baitap.session06.service;

import com.baitap.session06.dao.BookDao;
import com.baitap.session06.dao.BookDaoImp;
import com.baitap.session06.modal.Book;

import java.util.List;

public class BookServiceImp implements BookDao {
    public  BookDao bookDao;
    public  BookServiceImp() {
        bookDao = new BookDaoImp();
    }
    @Override
    public List<Book> getAllBook(int page, int size) {
        return bookDao.getAllBook(page, size);
    }

    @Override
    public boolean addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public boolean deleteBook(Book book) {
        return bookDao.deleteBook(book);
    }

    @Override
    public List<Book> filterBook(String keyword) {
        return bookDao.filterBook(keyword);
    }
}
