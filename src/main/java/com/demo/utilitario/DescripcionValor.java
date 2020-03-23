package com.demo.utilitario;

import java.util.List;

import org.json.JSONObject;

import com.demo.canonic.Studie;
import com.demo.canonic.Studies;

public class DescripcionValor{

	public static Object cambiarDescripcionValor(Object object, String tipoObjeto, String cadenaValores) {
		
		try {
			
			if(tipoObjeto.equals(Valores.studies)) {
				Studies studies = (Studies) object;
				List<Studie> listStudies = studies.getData();
				for(Studie studie: listStudies) {
					studie.setEstado(obtenerDescripcionValor(cadenaValores, "STATUS", studie.getEstado()));
				}
				studies.setData(listStudies);
				return studies;
			} else if(tipoObjeto.equals(Valores.studie)) {
				Studie studie = (Studie) object;
				studie.setEstado(obtenerDescripcionValor(cadenaValores, "STATUS", studie.getEstado()));
				return studie;
			}
			
		} catch (Exception e) {
			return object;
		}
		
		return object;
	}
	
	public static String obtenerDescripcionValor(String cadenaValores, String grupo, String valor) {
		JSONObject jsonCadenaObject = new JSONObject(cadenaValores);
		for (String keyCadenaStr : jsonCadenaObject.keySet()) {
	        Object keyCadenaValue = jsonCadenaObject.get(keyCadenaStr);
	        if(keyCadenaStr.equals(grupo)) {
	        	JSONObject jsonGrupoObject = new JSONObject(keyCadenaValue.toString());
	        	for (String keyGrupoStr : jsonGrupoObject.keySet()) {
	        		Object keyGrupoValue = jsonGrupoObject.get(keyGrupoStr);
	        		if(keyGrupoStr.equals(valor)) {
	        			return keyGrupoValue.toString();
	        		}
	        	}
	        }
	        
	    }
		return valor;
	}
	
	
}
