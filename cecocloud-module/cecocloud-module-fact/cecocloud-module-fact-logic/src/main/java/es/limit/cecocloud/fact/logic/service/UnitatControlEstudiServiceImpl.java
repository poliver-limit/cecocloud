/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.UnitatControlEstudi;
import es.limit.cecocloud.fact.logic.api.dto.UnitatControlEstudi.UnitatControlEstudiPk;
import es.limit.cecocloud.fact.logic.api.service.UnitatControlEstudiService;
import es.limit.cecocloud.fact.persist.entity.UnitatControlEstudiEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de UnitatControlEstudi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factUnitatControlEstudiService")
public class UnitatControlEstudiServiceImpl extends AbstractGenericCompositePkServiceImpl<UnitatControlEstudi, UnitatControlEstudiEntity, UnitatControlEstudiPk> implements UnitatControlEstudiService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Override
	protected UnitatControlEstudiPk getPkFromDto(UnitatControlEstudi dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new UnitatControlEstudiPk(
				identificador.getEmbedded().getCodi(),	
				dto.getEmpresa().getPk().getCodi(),
				dto.getProjecte().getPk().getCodi(),
				dto.getEstudiProjecte().getPk().getCodi(),
				dto.getEstudiProjecte().getPk().getNumero(),
				dto.getSequencia()
		);
	}

}
