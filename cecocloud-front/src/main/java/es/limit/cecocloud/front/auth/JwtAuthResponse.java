/**
 * 
 */
package es.limit.cecocloud.front.auth;

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
public final class JwtAuthResponse {

	private String token;
	private String tokenType;
	private long expiresIn;

}
