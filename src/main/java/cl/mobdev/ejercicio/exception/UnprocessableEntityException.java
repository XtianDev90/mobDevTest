package cl.mobdev.ejercicio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception para el status 422
 * @author Christian
 *
 */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnprocessableEntityException(String message) {
		super(message);
	}
}
