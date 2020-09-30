/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.LiniaFullFeina;
import es.limit.cecocloud.fact.logic.api.dto.LiniaFullFeina.LiniaFullFeinaPk;
import es.limit.cecocloud.fact.logic.api.service.LiniaFullFeinaService;
import es.limit.cecocloud.fact.persist.entity.LiniaFullFeinaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de una linia full feina.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factLiniaFullFeinaService")
public class LiniaFullFeinaServiceImpl extends AbstractGenericCompositePkServiceImpl<LiniaFullFeina, LiniaFullFeinaEntity, LiniaFullFeinaPk> implements LiniaFullFeinaService {
	
	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Override
	protected LiniaFullFeinaPk getPkFromDto(LiniaFullFeina dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new LiniaFullFeinaPk(
//				dto.getIdentificador().getId(),
				identificador.getEmbedded().getCodi(),		
				dto.getFinalFactura().getPk().getCodi(),				
				dto.getOrdre());
	}

}
