/**
 * 
 */
package es.limit.cecocloud.logic.api.dto.util;

import org.springframework.security.core.Authentication;

/**
 * Interfície per a accedir a l'objecte d'autenticació de Spring Security.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface AuthenticationFacade {

	public Authentication getAuthentication();

}
