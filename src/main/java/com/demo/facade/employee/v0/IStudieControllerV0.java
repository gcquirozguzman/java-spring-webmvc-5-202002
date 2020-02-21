package com.demo.facade.employee.v0;

import org.springframework.http.ResponseEntity;

import com.demo.canonic.Studie;
import com.demo.utilitario.Response;

public interface IStudieControllerV0 {
	ResponseEntity<Response> createStudie(Studie studie);
	ResponseEntity<Response> listStudie(int pagina);
	ResponseEntity<Response> deleteStudie(Long idStudie);
	ResponseEntity<Response> updateStudie(Studie studie);
	ResponseEntity<Response> getStudie(Long idStudie);
}
