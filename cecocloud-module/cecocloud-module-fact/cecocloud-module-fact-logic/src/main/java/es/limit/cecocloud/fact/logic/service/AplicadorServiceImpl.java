/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.Aplicador;
import es.limit.cecocloud.fact.logic.api.dto.Aplicador.AplicadorPk;
import es.limit.cecocloud.fact.logic.api.service.AplicadorService;
import es.limit.cecocloud.fact.persist.entity.AplicadorEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de aplicadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class AplicadorServiceImpl extends AbstractGenericCompositePkServiceImpl<Aplicador, AplicadorEntity, AplicadorPk> implements AplicadorService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private IdentificadorRepository identificadorRepository;

	@Override
	protected AplicadorPk getPkFromDto(Aplicador dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new AplicadorPk(
				identificador.getEmbedded().getCodi(),				
				dto.getContracte());
	}

}
