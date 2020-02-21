package com.demo.facade.employee.v0.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bussines.IEmployeeService;
import com.demo.canonic.Employee;
import com.demo.canonic.Employees;
import com.demo.facade.employee.v0.IEmployeeControllerV0;

@RestController
@RequestMapping("/employees/v0/")
public class EmployeeControllerV0 implements IEmployeeControllerV0 {
	
    @Autowired
    private IEmployeeService iEmployeeService;

    @Override
    @PostMapping("employees")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody Employee createEmployee(@Valid @RequestBody Employee employee) {
    	Employee newEmployee = iEmployeeService.createEmployee(employee);        
        return newEmployee;
    }

    @Override
    @GetMapping("employees/{pagina}")    
    public @ResponseBody Employees listEmployee(@PathVariable int pagina) {
        return iEmployeeService.listEmployee(pagina);
    }

    @Override
    @GetMapping("employees/{idEmployee}")
    public Employee getEmployee(@PathVariable Long idEmployee) {
    	return iEmployeeService.getEmployee(idEmployee);
    }

	@Override
	@DeleteMapping("employees/{idEmployee}")
	public void deleteEmployee(@PathVariable Long idEmployee) {
		iEmployeeService.deleteEmployee(idEmployee);
	}

	@Override
	@PutMapping("employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return iEmployeeService.updateEmployee(employee);
	}
}
