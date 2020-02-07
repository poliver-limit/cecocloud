/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.TipusClient;
import es.limit.cecocloud.fact.logic.api.dto.TipusClient.TipusClientPk;
import es.limit.cecocloud.fact.logic.api.service.TipusClientService;
import es.limit.cecocloud.fact.persist.entity.TipusClientEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de aplicadors-client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusClientServiceImpl extends AbstractGenericCompositePkServiceImpl<TipusClient, TipusClientEntity, TipusClientPk> implements TipusClientService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private IdentificadorRepository identificadorRepository;

	@Override
	protected TipusClientPk getPkFromDto(TipusClient dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new TipusClientPk(
				identificador.getEmbedded().getCodi(),
				dto.getClient().getPk().getCodi(),
				dto.getTipusProveidorClient().getPk().getCodi());
	}

}
