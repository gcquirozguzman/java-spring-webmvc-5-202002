package com.demo.utilitario;

public class Paginado {
	
	public static String tramaPaginacion(int pagina, int registrosPagina) {
		Integer valor_1 = registrosPagina;
		Integer valor_2 = valor_1 * (pagina-1);
		// Traer X registros(valor_1)			  desde el registros Y (valor_2) 
		return "limit "+String.valueOf(valor_1)+" offset "+String.valueOf(valor_2);
	}
	
}
