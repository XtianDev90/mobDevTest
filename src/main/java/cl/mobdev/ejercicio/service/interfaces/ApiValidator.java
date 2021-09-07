package cl.mobdev.ejercicio.service.interfaces;

import org.springframework.stereotype.Service;

import cl.mobdev.ejercicio.exception.UnprocessableEntityException;

/**
 * Valida el dato recibido como id en el request
 * @author Christian
 *
 */
@Service
public interface ApiValidator {
	
	void validatorId(Integer idCharacter) throws UnprocessableEntityException;
}
