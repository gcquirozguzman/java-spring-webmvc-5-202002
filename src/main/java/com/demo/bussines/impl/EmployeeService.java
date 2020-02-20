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
        return iEmployeeDAO.createEmployee(employee);
    }

    @Override
    public Employees listEmployee(int pagina) {
        return iEmployeeDAO.listEmployee(pagina);
    }

	@Override
	public void deleteEmployee(Long idEmployee) {
		iEmployeeDAO.deleteEmployee(idEmployee);
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return iEmployeeDAO.updateEmployee(employee);
	}

	@Override
	public Employee getEmployee(Long idEmployee) {
		return iEmployeeDAO.getEmployee(idEmployee);
	}
}
