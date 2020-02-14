package com.demo.utilitario;

public class Paginado {
	
	public static String tramaPaginacion(int pagina) {
		Integer valor_1 = Integer.parseInt("20"); // Pendiente que llame el properties
		Integer valor_2 = valor_1 * (pagina-1);
		return "limit "+String.valueOf(valor_1)+" offset "+String.valueOf(valor_2);
	}
	
}
