/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.Bestreta;
import es.limit.cecocloud.ecom.logic.api.dto.Bestreta.BestretaPk;
import es.limit.cecocloud.ecom.logic.api.service.BestretaService;
import es.limit.cecocloud.ecom.persist.entity.BestretaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de Bestreta.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomBestretaService")
public class BestretaServiceImpl extends AbstractGenericCompositePkServiceImpl<Bestreta, BestretaEntity, BestretaPk> implements BestretaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected BestretaPk getPkFromDto(Bestreta dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new BestretaPk(
				identificador.getEmbedded().getCodi(),				
				empresa.getEmbedded().getCodi(),
				dto.getPressupost().getPk().getCodi(),
				dto.getNumero()
		);
	}

}
