/**
 * 
 */
package es.limit.cecocloud.logic.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Resposta a la petició d'autenticació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Getter @Setter
@AllArgsConstructor
public final class AuthResponse {

	private String token;
	private String tokenType;

}
