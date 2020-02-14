package com.demo.dao.rowmapper;

import com.demo.canonic.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeListRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
    	Employee employee = new Employee();
    	employee.setId(resultSet.getLong("ID"));
    	employee.setNombre(resultSet.getString("NOMBRE"));
    	employee.setApellido(resultSet.getString("APELLIDO"));
    	employee.setEdad(resultSet.getLong("EDAD"));
    	employee.setSalario(resultSet.getBigDecimal("SALARIO"));
    	employee.setSexo(resultSet.getString("SEXO"));
        return employee;
    }
}
