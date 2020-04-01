/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.ProjectePressupost;
import es.limit.cecocloud.fact.logic.api.dto.ProjectePressupost.ProjectePressupostPk;
import es.limit.cecocloud.fact.logic.api.service.ProjectePressupostService;
import es.limit.cecocloud.fact.persist.entity.ProjectePressupostEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de pressupostos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProjectePressupostServiceImpl extends AbstractGenericCompositePkServiceImpl<ProjectePressupost, ProjectePressupostEntity, ProjectePressupostPk> implements ProjectePressupostService {

	@Autowired
	private AuthenticationHelper authenticationHelper;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	protected ProjectePressupostPk getPkFromDto(ProjectePressupost dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		return new ProjectePressupostPk(
				dto.getIdentificador().getId(),
				empresa.getEmbedded().getCodi(),
				dto.getPressupostNumero(),
				dto.getProjecteNumero());
	}

}
