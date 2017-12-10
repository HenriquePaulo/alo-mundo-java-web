package br.edu.alomundo.validator;

import java.util.Map;

import br.edu.alomundo.comum.MensagemConstantes;
import br.edu.alomundo.util.Util;
import br.edu.alumundo.exception.ValidationException;

public class CPFValidator implements Validator{

	@Override
	public boolean validar(Map<String, Object> valores) throws ValidationException {
		String msgErro = "";
		for (String key : valores.keySet()){
			String cpf = (String) valores.get(key);
			
			if (!cpf.isEmpty() && !Util.isCPF(cpf)){
				msgErro += MensagemConstantes.MSG_ERR_CPF_IVALIDO.replace("?", key).concat("<br>");
			}
		}
		if (msgErro.isEmpty())
			throw new ValidationException(msgErro);
	
		return true;
	}

}
