package com.baitap.session06.modal;

public class Book {
    int id;
    String title;
    String author;
    String type;
    int quantity;

    public Book() {
    }

    public Book(int id, String title, String author, String type, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.type = type;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
