/**
 * 
 */
package es.limit.cecocloud.logic.api.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Excepció que es llança quan es troba un token JWT invàlid.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@SuppressWarnings("serial")
@Getter @Setter
public class InvalidTokenException extends RuntimeException {
	
	private String token;
	private String message;

	public InvalidTokenException(
			String token,
			String message) {
		super(getExceptionMessage(
				token,
				message));
		this.token = token;
		this.message = message;
	}
	public InvalidTokenException(
			String token,
			String message,
			Throwable cause) {
		super(getExceptionMessage(
				token,
				message),
				cause);
		this.token = token;
		this.message = message;
	}

	private static String getExceptionMessage(
			String token,
			String message) {
		StringBuilder sb = new StringBuilder();
		sb.append(message);
		sb.append(" (token=");
		sb.append(token);
		sb.append(")");
		return sb.toString();
	}

}
