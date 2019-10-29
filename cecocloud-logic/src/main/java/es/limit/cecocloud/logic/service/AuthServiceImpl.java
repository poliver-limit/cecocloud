/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractAuthServiceImpl;

/**
 * Implementació del servei encarregat de gestionar l'autenticació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class AuthServiceImpl extends AbstractAuthServiceImpl {

	@Override
	protected List<ExternalGrantedAuthority> getAuthoritiesFromSession(Object session) {
		return null;
	}

}
