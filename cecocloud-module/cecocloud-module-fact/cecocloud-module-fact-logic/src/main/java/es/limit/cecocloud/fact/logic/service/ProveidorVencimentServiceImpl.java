/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.ProveidorVenciment;
import es.limit.cecocloud.fact.logic.api.dto.ProveidorVenciment.ProveidorVencimentPk;
import es.limit.cecocloud.fact.logic.api.service.ProveidorVencimentService;
import es.limit.cecocloud.fact.persist.entity.ProveidorVencimentEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de aplicadors.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ProveidorVencimentServiceImpl extends AbstractGenericCompositePkServiceImpl<ProveidorVenciment, ProveidorVencimentEntity, ProveidorVencimentPk> implements ProveidorVencimentService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	@Autowired
	private IdentificadorRepository identificadorRepository;
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	protected ProveidorVencimentPk getPkFromDto(ProveidorVenciment dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());		
		return new ProveidorVencimentPk(
				identificador.getEmbedded().getCodi(),				
				empresa.getEmbedded().getCodi(),
				dto.getProjecte().getPk().getCodi(),
				dto.getProveidor().getPk().getCodi());
	}

}
