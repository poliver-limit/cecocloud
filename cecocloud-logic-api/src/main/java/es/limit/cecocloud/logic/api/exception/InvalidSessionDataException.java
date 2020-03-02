/**
 * 
 */
package es.limit.cecocloud.logic.api.exception;

/**
 * Excepció que es llança quan l'usuari intenta establir una informació de
 * sessió que no està permesa (per exemple, intenta configurar una empresa
 * per a la que no te accés).
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@SuppressWarnings("serial")
public class InvalidSessionDataException extends RuntimeException {

	public InvalidSessionDataException(String message) {
		super(message);
	}

}
