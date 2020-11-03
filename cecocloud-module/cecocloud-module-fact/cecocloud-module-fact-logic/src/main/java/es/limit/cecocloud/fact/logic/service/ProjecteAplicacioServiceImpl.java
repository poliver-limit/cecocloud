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
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

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
	
	@Autowired
	private IdentificadorRepository identificadorRepository;

	@Override
	protected ProjecteAplicacioPk getPkFromDto(ProjecteAplicacio dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new ProjecteAplicacioPk(
				//dto.getIdentificador().getId(),
				identificador.getEmbedded().getCodi(),		
				empresa.getEmbedded().getCodi(),
				dto.getProjecte().getPk().getCodi(),
				dto.getCodi());
				
	}


}
