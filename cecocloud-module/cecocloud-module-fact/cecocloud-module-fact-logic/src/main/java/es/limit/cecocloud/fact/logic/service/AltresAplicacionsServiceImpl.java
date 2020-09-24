/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.AltresAplicacions;
import es.limit.cecocloud.fact.logic.api.dto.AltresAplicacions.AltresAplicacionsPk;
import es.limit.cecocloud.fact.logic.api.service.AltresAplicacionsService;
import es.limit.cecocloud.fact.persist.entity.AltresAplicacionsEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de altres aplicacions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factAltresAplicacionsService")
public class AltresAplicacionsServiceImpl extends AbstractGenericCompositePkServiceImpl<AltresAplicacions, AltresAplicacionsEntity, AltresAplicacionsPk> implements AltresAplicacionsService {
	
	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Override
	protected AltresAplicacionsPk getPkFromDto(AltresAplicacions dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new AltresAplicacionsPk(
//				dto.getIdentificador().getId(),
				identificador.getEmbedded().getCodi(),		
				dto.getTransportista().getPk().getCodi(),
				dto.getAplicacio(),
				dto.getCodi());
	}

}
