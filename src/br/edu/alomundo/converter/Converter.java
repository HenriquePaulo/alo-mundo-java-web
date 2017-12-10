package br.edu.alomundo.converter;

import br.edu.alomundo.util.Util;

public interface Converter {
	
	public String converterParaString(Object objeto);
	
	public Object converterParaObjeto(String valor);

}
