package com.baitap.session06.service;

import com.baitap.session06.dao.ProductDao;
import com.baitap.session06.dao.ProductDaoImp;
import com.baitap.session06.modal.Product;

import java.util.List;

public class ProductServiceImp implements ProductService {
    public ProductDao productDao;
    public ProductServiceImp() {
        productDao = new ProductDaoImp();
    }
    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }
}
