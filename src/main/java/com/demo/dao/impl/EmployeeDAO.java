package com.demo.dao.impl;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.canonic.Employee;
import com.demo.canonic.Employees;
import com.demo.dao.IEmployeeDAO;
import com.demo.dao.rowmapper.EmployeeListRowMapper;
@Component
public class EmployeeDAO implements IEmployeeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Employee createEmployee(Employee employee) {
    	KeyHolder keyHolder = new GeneratedKeyHolder();
    	String query = "INSERT INTO EMPLOYEE(NOMBRE,APELLIDO,EDAD,SALARIO,SEXO) VALUES (?,?,?,?,?)";
    	jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
              .prepareStatement(query);
            	ps.setString(1, employee.getNombre());
            	ps.setString(2, employee.getApellido());
            	ps.setLong(3, employee.getEdad());
            	ps.setBigDecimal(4, employee.getSalario());
            	ps.setString(5, employee.getSexo());              
              return ps;
            }, keyHolder);
    	long idGenerado = (long) keyHolder.getKey();
    	employee.setId(idGenerado);
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
