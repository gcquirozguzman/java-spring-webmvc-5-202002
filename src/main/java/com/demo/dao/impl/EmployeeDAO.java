package com.demo.dao.impl;

import com.demo.canonic.Employee;
import com.demo.canonic.Employees;
import com.demo.dao.IEmployeeDAO;
import com.demo.dao.rowmapper.EmployeeListRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
@Component
public class EmployeeDAO implements IEmployeeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Employee createEmployee(Employee employee) {
    	
//    	String query = 
//    	"INSERT INTO EMPLOYEE(NOMBRE,APELLIDO,EDAD,SALARIO,SEXO) " +
//    	"VALUES (?,?,?,?,?)";
//    	
//    	int row = jdbcTemplate.update(query, "Gian", "Quiroz", 20, new BigDecimal(20000), "Masculino");
//    	System.out.println(row);
        return employee;
    }

	@Override
	@Transactional
	public Employees listEmployee(int pagina) {
		List<Employee> employeeList = (List<Employee>) jdbcTemplate.query("select * from Employee",
                new EmployeeListRowMapper());
        
        Employees employees = new Employees();
        employees.setData(employeeList);
        return employees;
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

	@Override
	public Employee getEmployee(Long idEmployee) {
		// TODO Auto-generated method stub
		return null;
	}
}
