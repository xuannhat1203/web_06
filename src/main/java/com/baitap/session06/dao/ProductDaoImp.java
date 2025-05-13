
package com.baitap.session06.dao;

import com.baitap.session06.modal.Product;
import com.baitap.session06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImp implements ProductDao {
    @Override
    public List<Product> getProducts() {
        Connection con = null;
        CallableStatement cs = null;
        List<Product> products = new ArrayList<Product>();
        try {
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call get_all_products()}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImageUrl(rs.getString("imageurl"));
                products.add(product);
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
