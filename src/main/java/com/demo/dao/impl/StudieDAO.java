package com.demo.dao.impl;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.canonic.Studie;
import com.demo.canonic.Studies;
import com.demo.dao.IStudieDAO;
import com.demo.dao.rowmapper.StudieListRowMapper;
import com.demo.utilitario.DescripcionValor;
import com.demo.utilitario.Paginado;
import com.demo.utilitario.Valores;

@Component
public class StudieDAO implements IStudieDAO {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Value("${cantidad.registros.pagina}")
    int registrosPagina;
    
    @Value("${cadenaValores}")
    String cadenaValores;
    
    @Value("${query.studieDAO.createStudie}")
    String createStudie;
    
    @Value("${query.studieDAO.listStudie}")
    String listStudie;
    
    @Value("${query.studieDAO.deleteStudie}")
    String deleteStudie;
    
    @Value("${query.studieDAO.updateStudie}")
    String updateStudie;
    
    @Value("${query.studieDAO.getStudie}")
    String getStudie;
    
	@Override
	@Transactional
	public Studies listStudie(int pagina) {
		List<Studie> studieList = (List<Studie>) jdbcTemplate.query
				(createStudie+Paginado.tramaPaginacion(pagina, registrosPagina),
                new StudieListRowMapper());
		Studies studies = new Studies();
		studies.setData(studieList);
        return (Studies) DescripcionValor.cambiarDescripcionValor(studies, Valores.studies, cadenaValores);
	}

	@Override
	public Studie createStudie(Studie studie) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
    	String query = listStudie;
    	jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
              .prepareStatement(query);
            	ps.setLong(1, studie.getEmployee().getId());
            	ps.setString(2, studie.getDescripcion());
              return ps;
            }, keyHolder);
    	
    	Long idGenerado = (long) keyHolder.getKey().intValue();
    	studie.setId(idGenerado);    	
    	return studie;
	}

	@Override
	public void deleteStudie(Long idStudie) {
		jdbcTemplate.update(deleteStudie, new Object[] {idStudie});
	}

	@Override
	public Studie updateStudie(Studie studie) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
    	String query = updateStudie;
    	jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
              .prepareStatement(query);
            	ps.setLong(1, studie.getEmployee().getId());
            	ps.setString(2, studie.getDescripcion());
            	ps.setLong(3, studie.getId());
              return ps;
            }, keyHolder);
		return studie;
	}

	@Override
	public Studie getStudie(Long idStudie) {
		Studie studie = (Studie)jdbcTemplate
				.queryForObject(getStudie, 
				new Object[] {idStudie}, new StudieListRowMapper());
		return (Studie) DescripcionValor.cambiarDescripcionValor(studie, Valores.studie, cadenaValores);
	}
    
}
