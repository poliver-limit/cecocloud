/**
 * 
 */
package es.limit.cecocloud.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractAuthServiceImpl.BaseBootAuthenticationToken;
import es.limit.base.boot.logic.service.AbstractGenericServiceImpl;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.IdentificadorService;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.CompanyiaRepository;

/**
 * Implementació del servei de gestió d'identificadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("comuIdentificadorServiceImpl")
public class IdentificadorServiceImpl extends AbstractGenericServiceImpl<Identificador, IdentificadorEntity, Long> implements IdentificadorService {

	@Autowired
	private CompanyiaRepository companyiaRepository;
	
	@Override
	protected void beforeCreate(IdentificadorEntity entity, Identificador dto) {
		// Agafam la companyia de la sessió
		BaseBootAuthenticationToken auth = (BaseBootAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
		UserSession session = (UserSession)auth.getSession();
		CompanyiaEntity companyia = companyiaRepository.getOne(session.getCompanyia());
		entity.updateCompanyia(companyia);
	}

}
