/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.Avaria;
import es.limit.cecocloud.fact.logic.api.dto.Avaria.AvariaPk;
import es.limit.cecocloud.fact.logic.api.service.AvariaService;
import es.limit.cecocloud.fact.persist.entity.AvariaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de Avaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class AvariaServiceImpl extends AbstractGenericCompositePkServiceImpl<Avaria, AvariaEntity, AvariaPk> implements AvariaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected AvariaPk getPkFromDto(Avaria dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new AvariaPk(
				identificador.getEmbedded().getCodi(),			
				empresa.getEmbedded().getCodi(),
				dto.getNum());
	}

}
