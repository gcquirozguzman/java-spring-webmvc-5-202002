package com.demo.facade.employee.v0.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.demo.bussines.IEmployeeService;
import com.demo.canonic.Employee;
import com.demo.canonic.Employees;
import com.demo.facade.employee.v0.IEmployeeConrollerV0;

@RestController
@RequestMapping("/employees/v0")
public class EmployeeConrollerV0 implements IEmployeeConrollerV0 {
	
    @Autowired
    private IEmployeeService iEmployeeService;

    @RequestMapping(value = "/employees",method = RequestMethod.POST)
    @Override
    public @ResponseBody Employee createEmployee(@Valid @RequestBody Employee employee) {
    	Employee newEmployee = iEmployeeService.createEmployee(employee);        
        return newEmployee;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @Override
    public @ResponseBody Employees listEmployee() {
        return iEmployeeService.listEmployee();
    }

    @Override
    public Employee getEmployee(Long idEmployee) {
        return null;
    }

	@Override
	public void deleteEmployee(Long idEmployee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employees updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
}
