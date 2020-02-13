package com.demo.dao.rowmapper;

import com.demo.canonic.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeListRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("id"));
        employee.setNombre(resultSet.getString("nombre"));
        return employee;
    }
}
