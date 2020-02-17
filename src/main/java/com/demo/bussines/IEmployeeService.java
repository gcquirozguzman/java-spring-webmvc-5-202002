package com.demo.bussines;

import com.demo.canonic.Employee;
import com.demo.canonic.Employees;

public interface IEmployeeService {
	Employee createEmployee(Employee employee);
    Employees listEmployee(int pagina);
    void deleteEmployee(Long idEmployee);
    Employees updateEmployee(Employee employee);
    Employee getEmployee(Long idEmployee);
}
