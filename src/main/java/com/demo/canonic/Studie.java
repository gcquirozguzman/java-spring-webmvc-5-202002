package com.demo.canonic;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Studie implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
    private Employee employee;
	
	private String descripcion;
	
	private String estado;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
