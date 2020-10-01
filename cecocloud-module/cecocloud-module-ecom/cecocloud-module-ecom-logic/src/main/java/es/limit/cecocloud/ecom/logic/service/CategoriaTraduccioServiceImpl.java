/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.CategoriaTraduccio;
import es.limit.cecocloud.ecom.logic.api.dto.CategoriaTraduccio.CategoriaTraduccioPk;
import es.limit.cecocloud.ecom.logic.api.service.CategoriaTraduccioService;
import es.limit.cecocloud.ecom.persist.entity.CategoriaTraduccioEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de CategoriaTraduccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomCategoriaTraduccioService")
public class CategoriaTraduccioServiceImpl extends AbstractGenericCompositePkServiceImpl<CategoriaTraduccio, CategoriaTraduccioEntity, CategoriaTraduccioPk> implements CategoriaTraduccioService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Override
	protected CategoriaTraduccioPk getPkFromDto(CategoriaTraduccio dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new CategoriaTraduccioPk(
				identificador.getEmbedded().getCodi(),				
				dto.getSequencia()
		);
	}

}
