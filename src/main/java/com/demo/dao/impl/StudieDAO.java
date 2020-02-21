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
				("SELECT * FROM STUDIE A LEFT JOIN EMPLOYEE B " +
				 "ON A.IDEMPLOYEE = B.ID "+Paginado.tramaPaginacion(pagina, registrosPagina),
                new StudieListRowMapper());
		Studies studies = new Studies();
		studies.setData(studieList);
        return studies;
	}

	@Override
	public Studie createStudie(Studie studie) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
    	String query = "INSERT INTO STUDIE(IDEMPLOYEE,DESCRIPCION) VALUES (?,?)";
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
		jdbcTemplate.update("DELETE FROM STUDIE WHERE ID = ?", new Object[] {idStudie});
	}

	@Override
	public Studie updateStudie(Studie studie) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
    	String query = "UPDATE STUDIE SET IDEMPLOYEE=?,DESCRIPCION=? WHERE ID = ?";
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
				.queryForObject("SELECT * FROM STUDIE A LEFT JOIN EMPLOYEE B ON A.IDEMPLOYEE = B.ID WHERE A.ID = ?", 
				new Object[] {idStudie}, new StudieListRowMapper());
		return studie;
	}
    
}
