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
    	
    	Long idGenerado = (long) keyHolder.getKey().intValue();
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
		jdbcTemplate.update("delete from Employee where id = ?", new Object[] {idEmployee});
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
    	String query = "UPDATE EMPLOYEE SET NOMBRE=?,APELLIDO=?,EDAD=?,SALARIO=?,SEXO=? WHERE ID = ?";
    	jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
              .prepareStatement(query);
            	ps.setString(1, employee.getNombre());
            	ps.setString(2, employee.getApellido());
            	ps.setLong(3, employee.getEdad());
            	ps.setBigDecimal(4, employee.getSalario());
            	ps.setString(5, employee.getSexo());
            	ps.setLong(6, employee.getId());
              return ps;
            }, keyHolder);
		return employee;
	}

	@Override
	public Employee getEmployee(Long idEmployee) {
		Employee employee = (Employee)jdbcTemplate
				.queryForObject("select * from Employee where id = ?", 
				new Object[] {idEmployee}, new EmployeeListRowMapper());
		return employee;
	}
}
