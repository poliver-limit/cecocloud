/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.Capitol;
import es.limit.cecocloud.fact.logic.api.dto.Capitol.CapitolPk;
import es.limit.cecocloud.fact.logic.api.service.CapitolService;
import es.limit.cecocloud.fact.persist.entity.CapitolEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de Capitol.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CapitolServiceImpl extends AbstractGenericCompositePkServiceImpl<Capitol, CapitolEntity, CapitolPk> implements CapitolService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected CapitolPk getPkFromDto(Capitol dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new CapitolPk(
				dto.getIdentificador().getId(),				
				empresa.getEmbedded().getCodi(),
				100, // Recuperar el codi del Pressupost
				dto.getCodi());
	}

}
