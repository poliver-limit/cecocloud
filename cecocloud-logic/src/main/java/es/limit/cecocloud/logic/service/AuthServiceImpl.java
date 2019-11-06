/**
 * 
 */
package es.limit.cecocloud.logic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractAuthServiceImpl;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.RolEntity;
import es.limit.cecocloud.persist.repository.RolRepository;

/**
 * Implementació del servei encarregat de gestionar l'autenticació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class AuthServiceImpl extends AbstractAuthServiceImpl {

	@Autowired
	RolRepository rolRepository;

	@Override
	protected List<ExternalGrantedAuthority> getAuthoritiesFromSession(String usuariCodi, Object session) {
		List<ExternalGrantedAuthority> grantedAuthorities = new ArrayList<ExternalGrantedAuthority>();
		if (usuariCodi != null) {
			Long empresaId = null;
//			String identificadorCodi = null;
			UserSession userSession = (UserSession)session;
			if (userSession != null) {
				empresaId = userSession.getEmpresa();
//				identificadorCodi = userSession.getIdentificador();
			}
			if (empresaId != null) { // && identificadorCodi != null) {
				List<RolEntity> rols = rolRepository.findByUsuariCodiEmpresa(
						usuariCodi, 
						userSession.getEmpresa());
//						userSession.getIdentificador());
				if (rols != null && !rols.isEmpty()) {
					grantedAuthorities = rols.stream().map(rol -> new ExternalGrantedAuthority(rol.getEmbedded().getCodi())).collect(Collectors.toList()); 
				}
			}
		}
		return grantedAuthorities;
	}

}
