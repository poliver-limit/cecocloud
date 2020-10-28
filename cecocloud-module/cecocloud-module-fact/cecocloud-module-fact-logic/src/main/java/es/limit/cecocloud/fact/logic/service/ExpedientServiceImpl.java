/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.Expedient;
import es.limit.cecocloud.fact.logic.api.dto.Expedient.ExpedientPk;
import es.limit.cecocloud.fact.logic.api.service.ExpedientService;
import es.limit.cecocloud.fact.persist.entity.ExpedientEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;

/**
 * Implementació del servei de gestió de Expedient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ExpedientServiceImpl extends AbstractGenericCompositePkServiceImpl<Expedient, ExpedientEntity, ExpedientPk> implements ExpedientService {

	@Autowired
	private AuthenticationHelper authenticationHelper;	
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected ExpedientPk getPkFromDto(Expedient dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new ExpedientPk(
				identificador.getEmbedded().getCodi(),				
				empresa.getEmbedded().getCodi(),
				dto.getCodi());
	}

}
