/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.ProjecteTarifaProveidor;
import es.limit.cecocloud.fact.logic.api.dto.ProjecteTarifaProveidor.ProjecteTarifaProveidorPk;
import es.limit.cecocloud.fact.logic.api.service.ProjecteTarifaProveidorService;
import es.limit.cecocloud.fact.persist.entity.ProjecteTarifaProveidorEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de aplicadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProjecteTarifaProveidorServiceImpl extends AbstractGenericCompositePkServiceImpl<ProjecteTarifaProveidor, ProjecteTarifaProveidorEntity, ProjecteTarifaProveidorPk> implements ProjecteTarifaProveidorService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	protected ProjecteTarifaProveidorPk getPkFromDto(ProjecteTarifaProveidor dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());		
		return new ProjecteTarifaProveidorPk(
				identificador.getEmbedded().getCodi(),				
				empresa.getEmbedded().getCodi(),
				dto.getProjecte().getPk().getCodi(),
				dto.getProveidor().getPk().getCodi(),
				dto.getTarifaProveidor().getPk().getCodi());
	}

}
