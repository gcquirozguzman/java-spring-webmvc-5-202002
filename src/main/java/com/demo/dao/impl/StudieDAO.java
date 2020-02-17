package com.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    
    @Value("${cantidad.registros.pagina}")
    int registrosPagina;
    
	@Override
	@Transactional
	public Studies listStudie(int pagina) {
		
		List<Studie> studieList = (List<Studie>) jdbcTemplate.query
				("select * from Studie a left join Employee b " +
				 "on a.idEmployee = b.id "+Paginado.tramaPaginacion(pagina, registrosPagina),
                new StudieListRowMapper());
        
		Studies studies = new Studies();
		studies.setData(studieList);
		
        return studies;
	}

	@Override
	public Studie createStudie(Studie studie) {
		// TODO Auto-generated method stub
		return null;
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
