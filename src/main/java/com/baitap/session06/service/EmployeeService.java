package com.baitap.session06.service;

import com.baitap.session06.modal.Employee;

import java.util.List;

public interface EmployeeService {
    boolean addEmployee(Employee employee);
    boolean deleteEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
    List<Employee> searchEmployees(String keyword);
}
