/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.PreuPerGamma;
import es.limit.cecocloud.fact.logic.api.dto.PreuPerGamma.PreuPerGammaPk;
import es.limit.cecocloud.fact.logic.api.service.PreuPerGammaService;
import es.limit.cecocloud.fact.persist.entity.PreuPerGammaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de preu per zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factPreuPerGammaService")
public class PreuPerGammaServiceImpl extends AbstractGenericCompositePkServiceImpl<PreuPerGamma, PreuPerGammaEntity, PreuPerGammaPk> implements PreuPerGammaService {
	
	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Override
	protected PreuPerGammaPk getPkFromDto(PreuPerGamma dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new PreuPerGammaPk(
//				dto.getIdentificador().getId(),
				identificador.getEmbedded().getCodi(),		
				dto.getGamma().getPk().getCodi(),				
				dto.getTransportista().getPk().getCodi());
	}

}
