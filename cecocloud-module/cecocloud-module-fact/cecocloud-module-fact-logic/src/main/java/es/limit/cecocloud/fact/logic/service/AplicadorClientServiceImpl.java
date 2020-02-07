/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.AplicadorClient;
import es.limit.cecocloud.fact.logic.api.dto.AplicadorClient.AplicadorClientPk;
import es.limit.cecocloud.fact.logic.api.service.AplicadorClientService;
import es.limit.cecocloud.fact.persist.entity.AplicadorClientEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de aplicadors-client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class AplicadorClientServiceImpl extends AbstractGenericCompositePkServiceImpl<AplicadorClient, AplicadorClientEntity, AplicadorClientPk> implements AplicadorClientService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private IdentificadorRepository identificadorRepository;

	@Override
	protected AplicadorClientPk getPkFromDto(AplicadorClient dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new AplicadorClientPk(
				identificador.getEmbedded().getCodi(),
				dto.getClient().getPk().getCodi(),
				dto.getAplicador().getPk().getContracte());
	}

}
