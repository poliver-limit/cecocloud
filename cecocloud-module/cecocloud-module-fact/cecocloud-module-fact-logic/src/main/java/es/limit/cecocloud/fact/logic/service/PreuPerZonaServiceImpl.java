/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.PreuPerZona;
import es.limit.cecocloud.fact.logic.api.dto.PreuPerZona.PreuPerZonaPk;
import es.limit.cecocloud.fact.logic.api.service.PreuPerZonaService;
import es.limit.cecocloud.fact.persist.entity.PreuPerZonaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de preu per zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factPreuPerZonaService")
public class PreuPerZonaServiceImpl extends AbstractGenericCompositePkServiceImpl<PreuPerZona, PreuPerZonaEntity, PreuPerZonaPk> implements PreuPerZonaService {
	
	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Override
	protected PreuPerZonaPk getPkFromDto(PreuPerZona dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new PreuPerZonaPk(
//				dto.getIdentificador().getId(),
				identificador.getEmbedded().getCodi(),		
				dto.getZona().getPk().getCodi(),				
				dto.getTransportista().getPk().getCodi());
	}

}
