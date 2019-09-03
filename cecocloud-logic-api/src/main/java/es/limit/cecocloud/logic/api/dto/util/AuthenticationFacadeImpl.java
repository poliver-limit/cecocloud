/**
 * 
 */
package es.limit.cecocloud.logic.api.dto.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Implementació de la interfície AuthenticationFacade.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class AuthenticationFacadeImpl implements AuthenticationFacade {

	@Override
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

}
