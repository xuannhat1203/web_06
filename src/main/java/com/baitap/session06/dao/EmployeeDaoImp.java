
package com.baitap.session06.dao;

import com.baitap.session06.modal.Employee;
import com.baitap.session06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImp implements EmployeeDao {
    @Override
    public boolean addEmployee(Employee employee) {
        Connection con = null;
        CallableStatement cs = null;
        try {
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call add_employee(?, ?, ?, ?, ?, ?)}");
            cs.setString(1, employee.getName());
            cs.setDate(2, new java.sql.Date(employee.getBirthday().getTime()));
            cs.setString(3, employee.getPhone());
            cs.setString(4, employee.getEmail());
            cs.setDouble(5, employee.getSalary());
            cs.setString(6, employee.getPosition());
            return cs.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cs != null) try { cs.close(); } catch (Exception e) { e.printStackTrace(); }
            if (con != null) try { con.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        Connection con = null;
        CallableStatement cs = null;
        try {
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call delete_employee(?)}");
            cs.setInt(1, employee.getId());
            return cs.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cs != null) try { cs.close(); } catch (Exception e) { e.printStackTrace(); }
            if (con != null) try { con.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        Connection con = null;
        CallableStatement cs = null;
        try {
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call update_employee(?, ?, ?, ?, ?, ?, ?)}");
            cs.setInt(1, employee.getId());
            cs.setString(2, employee.getName());
            cs.setDate(3, new java.sql.Date(employee.getBirthday().getTime()));
            cs.setString(4, employee.getPhone());
            cs.setString(5, employee.getEmail());
            cs.setDouble(6, employee.getSalary());
            cs.setString(7, employee.getPosition());
            return cs.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cs != null) try { cs.close(); } catch (Exception e) { e.printStackTrace(); }
            if (con != null) try { con.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return false;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call get_employee_by_id(?)}");
            cs.setInt(1, id);
            rs = cs.executeQuery();
            if (rs.next()) {
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("birthday"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getDouble("salary"),
                        rs.getString("position")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (Exception e) { e.printStackTrace(); }
            if (cs != null) try { cs.close(); } catch (Exception e) { e.printStackTrace(); }
            if (con != null) try { con.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call get_all_employees()}");
            rs = cs.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("birthday"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getDouble("salary"),
                        rs.getString("position")
                );
                list.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (Exception e) { e.printStackTrace(); }
            if (cs != null) try { cs.close(); } catch (Exception e) { e.printStackTrace(); }
            if (con != null) try { con.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return list;
    }

    @Override
    public List<Employee> searchEmployees(String keyword) {
        List<Employee> list = new ArrayList<>();
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            con = ConnectionDB.openConnection();
            cs = con.prepareCall("{call search_employee(?)}");
            cs.setString(1, "%" + keyword + "%");
            rs = cs.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("birthday"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getDouble("salary"),
                        rs.getString("position")
                );
                list.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (Exception e) { e.printStackTrace(); }
            if (cs != null) try { cs.close(); } catch (Exception e) { e.printStackTrace(); }
            if (con != null) try { con.close(); } catch (Exception e) { e.printStackTrace(); }
        }
        return list;
    }
}
