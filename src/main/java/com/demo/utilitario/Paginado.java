package com.demo.utilitario;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value= {"classpath:resources/properties/paginacion.properties"})
public class Paginado {
	
	@Value("${cantidad.registros.pagina}")
    private static String cantidad_registros_paginado;
	
	public static String tramaPaginacion(int pagina) {
		Integer valor_1 = Integer.parseInt("20"); // Pendiente que llame el properties
		Integer valor_2 = valor_1 * (pagina-1);
		return "limit "+String.valueOf(valor_1)+" offset "+String.valueOf(valor_2);
	}
	
}
