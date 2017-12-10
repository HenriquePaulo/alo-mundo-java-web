package br.edu.alomundo.validator;

import java.util.Map;

import br.edu.alumundo.exception.ValidationException;

public interface Validator {
	
	public boolean validar (Map<String, Object> valores)throws ValidationException;

}
