/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.ProjecteAplicacio;
import es.limit.cecocloud.fact.logic.api.dto.ProjecteAplicacio.ProjecteAplicacioPk;
import es.limit.cecocloud.fact.logic.api.service.ProjecteAplicacioService;
import es.limit.cecocloud.fact.persist.entity.ProjecteAplicacioEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de projecte aplicacio
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProjecteAplicacioServiceImpl extends AbstractGenericCompositePkServiceImpl<ProjecteAplicacio, ProjecteAplicacioEntity, ProjecteAplicacioPk> implements ProjecteAplicacioService {
	
	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	protected ProjecteAplicacioPk getPkFromDto(ProjecteAplicacio dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());		
		return new ProjecteAplicacioPk(
				dto.getIdentificador().getId(),
				empresa.getEmbedded().getCodi(),
				"100", // TO DO: RECUPERAR EL PROJECTE
				dto.getCodi());
				
	}


}
