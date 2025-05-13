
package com.baitap.session06.controller;

import com.baitap.session06.modal.Employee;
import com.baitap.session06.service.EmployeeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmployeeController", urlPatterns = {"/EmployeeController"})
public class EmployeeController extends HttpServlet {
    private EmployeeServiceImp employeeServiceImp;

    @Override
    public void init() {
        employeeServiceImp = new EmployeeServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String search = request.getParameter("search");

        if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Employee employee = employeeServiceImp.getEmployeeById(id);
            request.setAttribute("idE", id);
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("views/updateEmployee.jsp").forward(request, response);
            return;
        }

        List<Employee> employees;
        if (search != null && !search.isEmpty()) {
            employees = employeeServiceImp.searchEmployees(search);
        } else {
            employees = employeeServiceImp.getAllEmployees();
        }

        request.setAttribute("employees", employees);
        request.getRequestDispatcher("views/employeeList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addEmployee".equals(action)) {
            try {
                String name = request.getParameter("name");
                String birthdayStr = request.getParameter("birthday");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                double salary = Double.parseDouble(request.getParameter("salary"));
                String position = request.getParameter("position");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthday = sdf.parse(birthdayStr);

                employeeServiceImp.addEmployee(new Employee(name, birthday, phone, email, salary, position));
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect("EmployeeController");
        }

        else if ("update".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String birthdayStr = request.getParameter("birthday");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                double salary = Double.parseDouble(request.getParameter("salary"));
                String position = request.getParameter("position");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthday = sdf.parse(birthdayStr);

                Employee employee = employeeServiceImp.getEmployeeById(id);
                employee.setName(name);
                employee.setBirthday(birthday);
                employee.setPhone(phone);
                employee.setEmail(email);
                employee.setSalary(salary);
                employee.setPosition(position);

                employeeServiceImp.updateEmployee(employee);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect("EmployeeController");
        }

        else if ("delete".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                Employee employee = employeeServiceImp.getEmployeeById(id);
                employeeServiceImp.deleteEmployee(employee);
            } catch (Exception e) {
                e.printStackTrace();
            }
            response.sendRedirect("EmployeeController");
        }
    }
}
