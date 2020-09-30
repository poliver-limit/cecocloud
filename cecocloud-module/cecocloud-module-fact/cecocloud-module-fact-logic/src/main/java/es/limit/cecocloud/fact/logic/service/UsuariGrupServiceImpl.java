/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.UsuariGrup;
import es.limit.cecocloud.fact.logic.api.dto.UsuariGrup.UsuariGrupPk;
import es.limit.cecocloud.fact.logic.api.service.UsuariGrupService;
import es.limit.cecocloud.fact.persist.entity.UsuariGrupEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de usuaris del grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("factUsuariGrupService")
public class UsuariGrupServiceImpl extends AbstractGenericCompositePkServiceImpl<UsuariGrup, UsuariGrupEntity, UsuariGrupPk> implements UsuariGrupService {
	
	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Override
	protected UsuariGrupPk getPkFromDto(UsuariGrup dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new UsuariGrupPk(
//				dto.getIdentificador().getId(),
				identificador.getEmbedded().getCodi(),		
				dto.getGrup().getPk().getCodi(),				
				dto.getUsuari());
	}

}
