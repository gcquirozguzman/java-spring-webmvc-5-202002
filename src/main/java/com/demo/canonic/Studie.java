package com.demo.canonic;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Studie implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
    private Employee employee;
	
	private String studie;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getStudie() {
		return studie;
	}

	public void setStudie(String studie) {
		this.studie = studie;
	}

}
