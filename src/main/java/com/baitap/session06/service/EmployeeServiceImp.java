package com.baitap.session06.service;

import com.baitap.session06.dao.EmployeeDao;
import com.baitap.session06.dao.EmployeeDaoImp;
import com.baitap.session06.modal.Employee;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService {
    public EmployeeDao employeeDao;
    public EmployeeServiceImp() {
        employeeDao = new EmployeeDaoImp();
    }
    @Override
    public boolean addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        return employeeDao.deleteEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public List<Employee> searchEmployees(String keyword) {
        return employeeDao.searchEmployees(keyword);
    }
}
