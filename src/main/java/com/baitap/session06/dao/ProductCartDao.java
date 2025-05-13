package com.baitap.session06.dao;
import com.baitap.session06.modal.Product;

import java.util.List;

public interface ProductCartDao {
    boolean addToCart(int userId, int productId, int quantity);
    boolean removeFromCart(int cartId);
    List<Product> getCartItems(int userId);
}
