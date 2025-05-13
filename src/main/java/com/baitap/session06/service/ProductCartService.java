package com.baitap.session06.service;
import com.baitap.session06.modal.Product;

import java.util.List;

public interface ProductCartService {
    boolean addToCart(int userId, int productId, int quantity);
    boolean removeFromCart(int cartId);
    List<Product> getCartItems(int userId);
}

