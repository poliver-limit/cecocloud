/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.LiniaEstudi;
import es.limit.cecocloud.fact.logic.api.dto.LiniaEstudi.LiniaEstudiPk;
import es.limit.cecocloud.fact.logic.api.service.LiniaEstudiService;
import es.limit.cecocloud.fact.persist.entity.LiniaEstudiEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de LiniaEstudi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factLiniaEstudiService")
public class LiniaEstudiServiceImpl extends AbstractGenericCompositePkServiceImpl<LiniaEstudi, LiniaEstudiEntity, LiniaEstudiPk> implements LiniaEstudiService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected LiniaEstudiPk getPkFromDto(LiniaEstudi dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		return new LiniaEstudiPk(
				identificador.getEmbedded().getCodi(),	
				empresa.getEmbedded().getCodi(),
				dto.getSequencia(),
				dto.getProjecte().getPk().getCodi(),
				dto.getEstudiProjecte().getPk().getCodi(),
				dto.getEstudiProjecte().getPk().getNumero()				
		);
	}

}
