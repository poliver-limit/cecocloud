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
import es.limit.cecocloud.persist.repository.EmpresaRepository;

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
	
	@Override
	protected PartidaPk getPkFromDto(Partida dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new PartidaPk(
				dto.getIdentificador().getId(),				
				empresa.getEmbedded().getCodi(),
				100, // Recuperar el codi del Pressupost
				"100", // Recuperar el codi del Capitol
				dto.getCodi());
	}

}
