package com.baitap.session06.dao;

import com.baitap.session06.modal.Employee;

import java.util.List;

public interface EmployeeDao {
    boolean addEmployee(Employee employee);
    boolean deleteEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
    List<Employee> searchEmployees(String keyword);
}
