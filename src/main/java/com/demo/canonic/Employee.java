package com.demo.canonic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.demo.validator.Sexo;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
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
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Studie> getStudies() {
		return studies;
	}

	public void setStudies(List<Studie> studies) {
		this.studies = studies;
	}

	@Sexo
	@NotEmpty(message = "Ingrese sexo")
	private String sexo;
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JsonManagedReference
	private List<Studie> studies;
	
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
