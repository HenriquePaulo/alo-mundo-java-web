package br.edu.alomundo.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import br.edu.alomundo.comum.MensagemConstantes;
import br.edu.alumundo.exception.ValidationException;

public class DataValidator implements Validator {

	@Override
	public boolean validar(Map<String, Object> valores) throws ValidationException {
		String msgErro = "";
		for (String key : valores.keySet()) {
			String data = (String) valores.get(key);
			if (!data.isEmpty()) {
				try {
					new SimpleDateFormat("dd/MM/yyyy").parse(data);
				} catch (ParseException e) {
					msgErro += MensagemConstantes.MSG_ERR_CAMPO_INVALIDO.replace("?", key).concat("<br>");
				}
			}
		}
		if (!msgErro.isEmpty())
			throw new ValidationException(MensagemConstantes.MSG_ERR_CAMPO_INVALIDO);

		return true;
	}

}
