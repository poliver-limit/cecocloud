/**
 * 
 */
package es.limit.cecocloud.cita.logic.api.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Excepció que es llança quan s'intenta crear una cita per a una hora no
 * disponible.
 * 
 * @author Limit Tecnologies
 */
@SuppressWarnings("serial")
@Getter @Setter
public class NotAvailableException extends RuntimeException {

	public NotAvailableException(String message) {
		super(message);
	}

}
