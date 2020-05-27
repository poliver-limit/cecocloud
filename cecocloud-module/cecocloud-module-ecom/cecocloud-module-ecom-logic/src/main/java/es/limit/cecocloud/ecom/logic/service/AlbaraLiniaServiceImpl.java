/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.AlbaraLinia;
import es.limit.cecocloud.ecom.logic.api.dto.AlbaraLinia.AlbaraLiniaPk;
import es.limit.cecocloud.ecom.logic.api.service.AlbaraLiniaService;
import es.limit.cecocloud.ecom.persist.entity.AlbaraLiniaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de AlbaraLinia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomAlbaraLiniaService")
public class AlbaraLiniaServiceImpl extends AbstractGenericCompositePkServiceImpl<AlbaraLinia, AlbaraLiniaEntity, AlbaraLiniaPk> implements AlbaraLiniaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected AlbaraLiniaPk getPkFromDto(AlbaraLinia dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new AlbaraLiniaPk(
				dto.getIdentificador().getId(),				
				empresa.getEmbedded().getCodi(),
				dto.getAlbara().getPk().getNumeroDocument(),
				dto.getNumero());
	}

}
