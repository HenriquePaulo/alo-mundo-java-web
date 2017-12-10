package br.edu.alomundo.converter;

import br.edu.alomundo.util.Util;

public class CPFConverter implements Converter {
	
	public String converterParaString(Object objeto){
		String cpf = (String) objeto;
		
		return Util.imprimeCPF(cpf);
		
	}
	
	public Object converterParaObjeto(String valor){
		valor = valor.replaceAll("\\.", "").replaceAll("-", "");
		return Long.parseLong(valor);
	}

}
