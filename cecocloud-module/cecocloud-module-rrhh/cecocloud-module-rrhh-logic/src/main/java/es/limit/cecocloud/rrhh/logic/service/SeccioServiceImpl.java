/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio.SeccioPk;
import es.limit.cecocloud.rrhh.logic.api.service.SeccioService;
import es.limit.cecocloud.rrhh.persist.entity.SeccioEntity;

/**
 * Implementació del servei de gestió de seccions grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SeccioServiceImpl extends AbstractGenericCompositePkServiceImpl<Seccio, SeccioEntity, SeccioPk> implements SeccioService {
	
	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	protected SeccioPk getPkFromDto(Seccio dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new SeccioPk(
				dto.getIdentificador().getId(),
				empresa.getEmbedded().getCodi(),
				dto.getCodi());
	}

}
