/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.Partida;
import es.limit.cecocloud.fact.logic.api.dto.Partida.PartidaPk;
import es.limit.cecocloud.fact.logic.api.service.PartidaService;
import es.limit.cecocloud.fact.persist.entity.PartidaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de Partida.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class PartidaServiceImpl extends AbstractGenericCompositePkServiceImpl<Partida, PartidaEntity, PartidaPk> implements PartidaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Override
	protected PartidaPk getPkFromDto(Partida dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new PartidaPk(
				//dto.getIdentificador().getId(),				
				identificador.getEmbedded().getCodi(),	empresa.getEmbedded().getCodi(),
				dto.getPressupost().getPk().getCodi(),
				dto.getCapitol().getPk().getCodi(),
				dto.getCodi());
	}

}
