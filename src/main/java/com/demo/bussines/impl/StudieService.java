package com.demo.bussines.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.bussines.IStudieService;
import com.demo.canonic.Studie;
import com.demo.canonic.Studies;
import com.demo.dao.IStudieDAO;

@Component
public class StudieService implements IStudieService{
	
	@Autowired
    private IStudieDAO iStudieDAO;
	
	@Override
	public Studies listStudie(int pagina) {
		return iStudieDAO.listStudie(pagina);
	}

	@Override
	public Studie createStudie(Studie studie) {
		return iStudieDAO.createStudie(studie);
	}

	@Override
	public void deleteStudie(Long idStudie) {
		iStudieDAO.deleteStudie(idStudie);
	}

	@Override
	public Studie updateStudie(Studie studie) {
		return iStudieDAO.updateStudie(studie);
	}

	@Override
	public Studie getStudie(Long idStudie) {
		return iStudieDAO.getStudie(idStudie);
	}

}
