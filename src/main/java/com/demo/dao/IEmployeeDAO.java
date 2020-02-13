package com.demo.dao;

import com.demo.canonic.Employee;
import com.demo.canonic.Employees;

public interface IEmployeeDAO {
    Employee createEmployee(Employee employee);
    Employees listEmployee();
}
