/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.Albara;
import es.limit.cecocloud.ecom.logic.api.dto.Albara.AlbaraPk;
import es.limit.cecocloud.ecom.logic.api.service.AlbaraService;
import es.limit.cecocloud.ecom.persist.entity.AlbaraEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de provincies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomAlbaraService")
public class AlbaraServiceImpl extends AbstractGenericCompositePkServiceImpl<Albara, AlbaraEntity, AlbaraPk> implements AlbaraService {
	
	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	protected AlbaraPk getPkFromDto(Albara dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		return new AlbaraPk(
				dto.getIdentificador().getId(),
				empresa.getEmbedded().getCodi(),
				dto.getNumeroDocument());
	}

}
