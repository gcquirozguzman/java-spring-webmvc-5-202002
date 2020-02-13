package com.demo.bussines.impl;

import com.demo.bussines.IEmployeeService;
import com.demo.canonic.Employee;
import com.demo.canonic.Employees;
import com.demo.dao.IEmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService implements IEmployeeService{

    @Autowired
    private IEmployeeDAO iEmployeeDAO;

    @Override
    public Employee createEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employees listEmployee() {
        return iEmployeeDAO.listEmployee();
    }
}
