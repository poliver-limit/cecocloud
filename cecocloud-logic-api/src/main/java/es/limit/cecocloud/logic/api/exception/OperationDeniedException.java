/**
 * 
 */
package es.limit.cecocloud.logic.api.exception;

/**
 * Excepció que es llança quan l'usuari no te permisos per accedir a un mòdul.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@SuppressWarnings("serial")
public class OperationDeniedException extends RuntimeException {

	public OperationDeniedException(String message) {
		super("Operació no permesa: " + message);
	}

}
