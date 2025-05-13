package com.baitap.session06.dao;

import com.baitap.session06.modal.User;
import com.baitap.session06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class UserDaoImp implements UserDao {
    @Override
    public User getUserById(String username, String password) {
        Connection con = null;
        CallableStatement cstmt = null;
        User user = new User();
        try {
            con = ConnectionDB.openConnection();
            cstmt = con.prepareCall("{call get_acount(?,?)}");
            cstmt.setString(1, username);
            cstmt.setString(2, password);
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            return user;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = ConnectionDB.openConnection();
            cstmt = con.prepareCall("{call add_new_account(?,?,?,?)}");
            cstmt.setString(1, user.getUsername());
            cstmt.setString(2, user.getPassword());
            cstmt.setString(3, user.getEmail());
            cstmt.setString(4, user.getPhone());
            return cstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return false;
    }
}
