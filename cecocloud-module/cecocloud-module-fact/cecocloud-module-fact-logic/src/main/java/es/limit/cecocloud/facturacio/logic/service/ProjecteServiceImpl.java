package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.Projecte;
import es.limit.cecocloud.facturacio.logic.api.dto.Projecte.ProjectePk;
import es.limit.cecocloud.facturacio.logic.api.service.ProjecteService;
import es.limit.cecocloud.facturacio.persist.entity.ProjecteEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de Projecte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProjecteServiceImpl extends AbstractGenericCompositePkServiceImpl<Projecte, ProjecteEntity, ProjectePk> implements ProjecteService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	protected ProjectePk getPkFromDto(Projecte dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		return new ProjectePk(
				identificador.getEmbedded().getCodi(),
				empresa.getEmbedded().getCodi(),
				dto.getCodi());
	}

}