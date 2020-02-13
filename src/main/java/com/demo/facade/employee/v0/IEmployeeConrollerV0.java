package com.demo.facade.employee.v0;

import com.demo.canonic.Employee;
import com.demo.canonic.Employees;

public interface IEmployeeConrollerV0 {
    Employee createEmployee(Employee employee);
    Employees listEmployee();
    Employee getEmployee(Long idEmployee);
}
