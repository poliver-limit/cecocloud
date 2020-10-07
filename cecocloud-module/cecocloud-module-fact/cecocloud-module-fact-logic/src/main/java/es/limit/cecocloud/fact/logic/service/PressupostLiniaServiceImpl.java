/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.PressupostLinia;
import es.limit.cecocloud.fact.logic.api.dto.PressupostLinia.PressupostLiniaPk;
import es.limit.cecocloud.fact.logic.api.service.PressupostLiniaService;
import es.limit.cecocloud.fact.persist.entity.PressupostLiniaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de PressupostLinia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factPressupostLiniaService")
public class PressupostLiniaServiceImpl extends AbstractGenericCompositePkServiceImpl<PressupostLinia, PressupostLiniaEntity, PressupostLiniaPk> implements PressupostLiniaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected PressupostLiniaPk getPkFromDto(PressupostLinia dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new PressupostLiniaPk(
//				dto.getIdentificador().getId(),		
				identificador.getEmbedded().getCodi(),		
				empresa.getEmbedded().getCodi(),
				dto.getPressupost().getPk().getCodi(),
				dto.getNumero());
	}

}
