package com.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.canonic.Studie;
import com.demo.canonic.Studies;
import com.demo.dao.IStudieDAO;
import com.demo.dao.rowmapper.StudieListRowMapper;
import com.demo.utilitario.Paginado;

@Component
public class StudieDAO implements IStudieDAO {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
	@Override
	@Transactional
	public Studies listStudie(int pagina) {
		
		List<Studie> studieList = (List<Studie>) jdbcTemplate.query
				("select * from Studie a left join Employee b " +
				 "on a.idEmployee = b.id "+Paginado.tramaPaginacion(pagina),
                new StudieListRowMapper());
        
		Studies studies = new Studies();
		studies.setData(studieList);
		
        return studies;
	}
    
}
