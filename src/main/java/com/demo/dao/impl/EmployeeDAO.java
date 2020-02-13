package com.demo.dao.impl;

import com.demo.canonic.Employee;
import com.demo.canonic.Employees;
import com.demo.dao.IEmployeeDAO;
import com.demo.dao.rowmapper.EmployeeListRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
public class EmployeeDAO implements IEmployeeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Employee createEmployee(Employee employee) {
        return null;
    }
    @Transactional
    @Override
    public Employees listEmployee() {
        List<Employee> employeeList = (List<Employee>) jdbcTemplate.query("select * from Employee",
                new EmployeeListRowMapper());
        Employees employees = new Employees();
        employees.setData(employeeList);
        return employees;
    }
}
