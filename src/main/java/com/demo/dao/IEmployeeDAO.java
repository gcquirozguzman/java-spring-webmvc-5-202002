package com.demo.dao;

import com.demo.canonic.Employee;
import com.demo.canonic.Employees;

public interface IEmployeeDAO {
	Employee createEmployee(Employee employee);
    Employees listEmployee(int pagina);
    void deleteEmployee(Long idEmployee);
    Employee updateEmployee(Employee employee);
    Employee getEmployee(Long idEmployee);
}
