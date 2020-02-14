package com.demo.facade.employee.v0.impl;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.demo.bussines.IStudieService;
import com.demo.canonic.Studie;
import com.demo.canonic.Studies;
import com.demo.facade.employee.v0.IStudieConrollerV0;

@RestController
@RequestMapping(path = "/studies/v0", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudieConrollerV0 implements IStudieConrollerV0 {

	@Autowired
    private IStudieService iStudieService;
	
	@Value("${dateFormat}")
	String dateFormat;
	
	@Override
	public Studie createStudie(Studie studie) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/studies", method = RequestMethod.GET)
    @Override
    public @ResponseBody Studies listStudie() {
		System.out.println(dateFormat);
		// Necesito la pagina 2. Considerando que se cuentan registros de 20 en 20.
        return iStudieService.listStudie(2);
    }

	@Override
	public void deleteStudie(Long idStudie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Studies updateStudie(Studie studie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Studie getStudie(Long idStudie) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
