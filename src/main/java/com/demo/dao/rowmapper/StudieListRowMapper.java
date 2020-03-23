package com.demo.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.demo.canonic.Employee;
import com.demo.canonic.Studie;

public class StudieListRowMapper implements RowMapper<Studie> {
    @Override
    public Studie mapRow(ResultSet resultSet, int i) throws SQLException {
    	Studie studie = new Studie();
    	studie.setId(resultSet.getLong("STUDIE.ID"));
    	studie.setDescripcion(resultSet.getString("STUDIE.DESCRIPCION"));
    	studie.setEstado(resultSet.getString("STUDIE.ESTADO"));
    	Employee employee = new Employee();
    	employee.setId(resultSet.getLong("EMPLOYEE.ID"));
    	employee.setNombre(resultSet.getString("EMPLOYEE.NOMBRE"));
    	employee.setApellido(resultSet.getString("EMPLOYEE.APELLIDO"));
    	employee.setEdad(resultSet.getLong("EMPLOYEE.EDAD"));
    	employee.setSalario(resultSet.getBigDecimal("EMPLOYEE.SALARIO"));
    	employee.setSexo(resultSet.getString("EMPLOYEE.SEXO"));
    	studie.setEmployee(employee);
        return studie;
    }
}
