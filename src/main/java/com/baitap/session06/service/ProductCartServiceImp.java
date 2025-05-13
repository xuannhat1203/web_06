package com.baitap.session06.service;

import com.baitap.session06.dao.ProductCartDao;
import com.baitap.session06.dao.ProductCartDaoImp;
import com.baitap.session06.modal.Product;

import java.util.List;

public class ProductCartServiceImp implements ProductCartService {
    public ProductCartDao productCartDao;
    public ProductCartServiceImp() {
        productCartDao = new ProductCartDaoImp();
    }

    @Override
    public boolean addToCart(int userId, int productId, int quantity) {
        return productCartDao.addToCart(userId,productId,quantity);
    }

    @Override
    public boolean removeFromCart(int cartId) {
        return productCartDao.removeFromCart(cartId);
    }

    @Override
    public List<Product> getCartItems(int userId) {
        return productCartDao.getCartItems(userId);
    }
}
