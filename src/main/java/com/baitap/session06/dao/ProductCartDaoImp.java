
package com.baitap.session06.dao;

import com.baitap.session06.modal.Product;
import com.baitap.session06.utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductCartDaoImp implements ProductCartDao {

    @Override
    public boolean addToCart(int userId, int productId, int quantity) {
        try (Connection con = ConnectionDB.openConnection()) {
            CallableStatement cs = con.prepareCall("{call add_to_cart(?, ?, ?)}");
            cs.setInt(1, userId);
            cs.setInt(2, productId);
            cs.setInt(3, quantity);
            return  cs.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeFromCart(int cartId) {
        try (Connection con = ConnectionDB.openConnection()) {
            CallableStatement cs = con.prepareCall("{call delete_product_in_cart(?)}");
            cs.setInt(1, cartId);
            return  cs.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> getCartItems(int userId) {
        List<Product> cartItems = new ArrayList<>();
        try (Connection con = ConnectionDB.openConnection()) {
            CallableStatement cs = con.prepareCall("{call get_cart_items(?)}");
            cs.setInt(1, userId);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id")); // cartId
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setImageUrl(rs.getString("imageurl"));
                cartItems.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cartItems;
    }
}
