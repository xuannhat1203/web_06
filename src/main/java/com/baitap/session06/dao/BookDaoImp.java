package com.baitap.session06.dao;

import com.baitap.session06.modal.Book;
import com.baitap.session06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class BookDaoImp implements BookDao {
    @Override
    public List<Book> getAllBook(int page, int size) {
        Connection con = null;
        CallableStatement cstmt = null;
        List<Book> books = new ArrayList<Book>();
        try {
            con = ConnectionDB.openConnection();
            cstmt = con.prepareCall("{call get_all_books(?,?)}");
            int offset = (page - 1) * size;
            if (offset < 0) offset = 0;
            cstmt.setInt(1, offset);
            cstmt.setInt(2, size);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setAuthor(rs.getString("author"));
                book.setTitle(rs.getString("title"));
                book.setType(rs.getString("type"));
                book.setQuantity(rs.getInt("quantity"));
                books.add(book);
            }
            return books;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return null;
    }

    @Override
    public boolean addBook(Book book) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = ConnectionDB.openConnection();
            cstmt = con.prepareCall("{call add_new_book(?,?,?,?,?)}");
            cstmt.setInt(1,book.getId());
            cstmt.setString(2,book.getTitle());
            cstmt.setString(3,book.getAuthor());
            cstmt.setString(4,book.getType());
            cstmt.setInt(5,book.getQuantity());
            return cstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return false;
    }
    @Override
    public boolean updateBook(Book book) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = ConnectionDB.openConnection();
            cstmt = con.prepareCall("{call edit_book_by_id(?,?,?,?,?)}");
            cstmt.setInt(1,book.getId());
            cstmt.setString(2,book.getTitle());
            cstmt.setString(3,book.getAuthor());
            cstmt.setString(4,book.getType());
            cstmt.setInt(5,book.getQuantity());
            return cstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBook(Book book) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = ConnectionDB.openConnection();
            cstmt = con.prepareCall("{call delete_book_by_id(?)}");
            cstmt.setInt(1,book.getId());
            return cstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return false;
    }

    @Override
    public List<Book> filterBook(String keyword) {
        Connection con = null;
        CallableStatement cstmt = null;
        List<Book> books = new ArrayList<Book>();
        try {
            con = ConnectionDB.openConnection();
            cstmt = con.prepareCall("{call find_book_to_id_or_title(?)}");
            cstmt.setString(1,keyword);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setAuthor(rs.getString("author"));
                book.setTitle(rs.getString("title"));
                book.setType(rs.getString("type"));
                book.setQuantity(rs.getInt("quantity"));
                books.add(book);
            }
            return books;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return null;
    }
}
