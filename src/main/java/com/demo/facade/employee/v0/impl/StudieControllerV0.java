package com.demo.facade.employee.v0.impl;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.bussines.IStudieService;
import com.demo.canonic.Studie;
import com.demo.canonic.Studies;
import com.demo.facade.employee.v0.IStudieControllerV0;
import com.demo.utilitario.Error;
import com.demo.utilitario.Response;

@RestController
@RequestMapping("/studies/v0/")
public class StudieControllerV0 implements IStudieControllerV0 {

	@Autowired
    private IStudieService iStudieService;
	
	@Override
	@PostMapping("crear")
	public ResponseEntity<Response> createStudie(@Valid @RequestBody Studie studie) {
		Response response = new Response();
		try {
			Studie studieResponse = iStudieService.createStudie(studie);
			response.setBody(studieResponse);
		} catch (Exception e) {
			response.setError(new Error("ERROR_GENERICO", e.toString()));
		}
		return ResponseEntity.ok()
			      .body(response);
	}

	@Override
    @GetMapping("listar/{pagina}")
    public ResponseEntity<Response> listStudie(@PathVariable int pagina) {
		Response response = new Response();
		try {
			Studies studieResponse = iStudieService.listStudie(pagina);
			response.setBody(studieResponse);
		} catch (Exception e) {
			response.setError(new Error("ERROR_GENERICO", e.toString()));
		}
		return ResponseEntity.ok()
			      .body(response);
    }

	@Override
	@GetMapping("buscar/{idStudie}")
	public ResponseEntity<Response> getStudie(@PathVariable Long idStudie) {
		Response response = new Response();
		try {
			Studie studieResponse = iStudieService.getStudie(idStudie);
			response.setBody(studieResponse);
		} catch (Exception e) {
			response.setError(new Error("ERROR_GENERICO", e.toString()));
		}
		return ResponseEntity.ok()
			      .body(response);
	}
	
	@Override
	@DeleteMapping("eliminar/{idStudie}")
	public ResponseEntity<Response> deleteStudie(@PathVariable Long idStudie) {
		Response response = new Response();
		try {
			iStudieService.deleteStudie(idStudie);
		} catch (Exception e) {
			response.setError(new Error("ERROR_GENERICO", e.toString()));
		}
		return ResponseEntity.ok()
			      .body(response);
	}

	@Override
	@PutMapping("actualizar")
	public ResponseEntity<Response> updateStudie(@RequestBody Studie studie) {
		Response response = new Response();
		try {
			Studie studieResponse = iStudieService.updateStudie(studie);
			response.setBody(studieResponse);
		} catch (Exception e) {
			response.setError(new Error("ERROR_GENERICO", e.toString()));
		}
		return ResponseEntity.ok()
			      .body(response);
	}

	
	
}
