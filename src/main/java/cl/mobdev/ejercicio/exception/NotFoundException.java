package cl.mobdev.ejercicio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception para el status 404
 * @author Christian
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {
	// Considerar extender de RuntimeException, ya que simplemente se lanzan para terminar el flujo

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException(String message) {
		super(message);
	}
}
