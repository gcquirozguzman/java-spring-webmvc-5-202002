package com.demo.canonic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.demo.validator.Sexo;

@Entity
@NamedQueries(
		@NamedQuery(name = "Employee.insert", query = "INSERT INTO EMPLOYEE(NOMBRE,APELLIDO,EDAD,SALARIO,SEXO) VALUES (?,?,?,?,?)")
)
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message = "Ingrese nombre")
    private String nombre;
	
	@NotEmpty(message = "Ingrese apellido")
	private String apellido;
	
	@NotNull(message = "Ingrese edad")
	private Long edad;
	
	@DecimalMin("850.00")
	@NotNull(message = "Ingrese salario")
	private BigDecimal salario;	
	
	@NotNull(message = "Ingrese fecha de nacimiento")
	private Date fechaNacimiento;
	
	@Sexo
	@NotEmpty(message = "Ingrese sexo")
	private String sexo;
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	
}
