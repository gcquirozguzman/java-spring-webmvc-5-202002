package com.demo.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SexoValidator implements ConstraintValidator<Sexo, String>{

	List<String> sexoReconocido = Arrays.asList("Masculino", "Femenino");
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {		
		return sexoReconocido.contains(value);
	}
	
	
}