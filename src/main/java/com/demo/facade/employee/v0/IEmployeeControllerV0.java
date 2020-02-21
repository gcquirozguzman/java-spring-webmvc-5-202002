package com.demo.facade.employee.v0;

import com.demo.canonic.Employee;
import com.demo.canonic.Employees;

public interface IEmployeeControllerV0 {
    Employee createEmployee(Employee employee);
    Employees listEmployee(int pagina);
    void deleteEmployee(Long idEmployee);
    Employee updateEmployee(Employee employee);
    Employee getEmployee(Long idEmployee);
}
