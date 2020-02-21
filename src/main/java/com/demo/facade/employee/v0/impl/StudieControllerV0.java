package com.demo.facade.employee.v0.impl;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.demo.bussines.IStudieService;
import com.demo.canonic.Studie;
import com.demo.canonic.Studies;
import com.demo.facade.employee.v0.IStudieControllerV0;

@RestController
@RequestMapping("/studies/v0/")
public class StudieControllerV0 implements IStudieControllerV0 {

	@Autowired
    private IStudieService iStudieService;
	
	@PostMapping("studies")
    @ResponseStatus(code = HttpStatus.CREATED)
	public Studie createStudie(@Valid @RequestBody Studie studie) {
		return iStudieService.createStudie(studie);
	}

	@Override
    @GetMapping("studies/{pagina}")
    public @ResponseBody Studies listStudie(@PathVariable int pagina) {
        return iStudieService.listStudie(pagina);
    }

	@Override
	@GetMapping("studies/{idStudie}")
	public Studie getStudie(@PathVariable Long idStudie) {
		return iStudieService.getStudie(idStudie);
	}
	
	@Override
	@DeleteMapping("studies/{idStudie}")
	public void deleteStudie(@PathVariable Long idStudie) {
		iStudieService.deleteStudie(idStudie);
	}

	@Override
	@PutMapping("studies")
	public Studie updateStudie(@RequestBody Studie studie) {
		return iStudieService.updateStudie(studie);
	}

	
	
}
