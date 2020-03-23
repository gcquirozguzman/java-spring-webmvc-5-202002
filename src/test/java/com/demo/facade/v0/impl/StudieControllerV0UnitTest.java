package com.demo.facade.v0.impl;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.bussines.IStudieService;
import com.demo.canonic.Employee;
import com.demo.canonic.Studie;
import com.demo.facade.employee.v0.impl.StudieControllerV0;
import com.demo.facade.v0.IStudieControllerV0UnitTest;
import com.demo.utilitario.CORSFilter;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class StudieControllerV0UnitTest implements IStudieControllerV0UnitTest{

	private MockMvc mockMvc;
	
	@Mock
	private IStudieService iStudieService;
	
	@InjectMocks
	private StudieControllerV0 StudieControllerV0;

	@Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(StudieControllerV0)
                .addFilters(new CORSFilter())
                .build();
    }

	@Test
	@Override
	public void getStudie() throws Exception {
		
		Employee employee = new Employee();
		employee.setNombre("Nombre 1");
		employee.setApellido("Apellido 1");
		employee.setEdad((long) 21);
		employee.setSalario(new BigDecimal(11000));
		employee.setSexo("Masculino");
		Studie studieResponse = new Studie();
		studieResponse.setId((long) 1);
		studieResponse.setDescripcion("Studie 1.1");
		studieResponse.setEstado("Activo");
		studieResponse.setEmployee(employee);
		
        when(iStudieService.getStudie(studieResponse.getId())).thenReturn(studieResponse);
        
        mockMvc.perform(get("/studies/v0/buscar/{idStudie}", 1))
	        .andExpect(status().isOk())
	        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
	        .andExpect(jsonPath("$.body.id", is(1)))
	        .andExpect(jsonPath("$.body.descripcion", is("Studie 1.1")));
        
		verify(iStudieService, times(1)).getStudie((long) 1);
		verifyNoMoreInteractions(iStudieService);
		
	}
	
}