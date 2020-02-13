package com.demo.bussines;

import com.demo.canonic.Employee;
import com.demo.canonic.Employees;

public interface IEmployeeService {
    Employee createEmployee(Employee employee);
    Employees listEmployee();
}
