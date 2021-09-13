package cl.mobdev.ejercicio.util;

import org.springframework.stereotype.Component;

import cl.mobdev.ejercicio.exception.UnprocessableEntityException;
import cl.mobdev.ejercicio.service.interfaces.ApiValidator;

@Component
public class ApiValidatorImpl implements ApiValidator{

	@Override
	//el nombre del metodo pudiese ser validateId
	public void validatorId(Integer idCharacter) throws UnprocessableEntityException {
		if(idCharacter == null || idCharacter == 0) {
			//extraer esta linea en un metodo que se llame message hace que sea mas dificil de entender que solo 'throw new UnprocessableEntityException(message);' 
			message("El id es un campo obligatorio.");
		}
		
	}

	private void message(String message) throws UnprocessableEntityException {
		throw new UnprocessableEntityException(message);
	}
}
