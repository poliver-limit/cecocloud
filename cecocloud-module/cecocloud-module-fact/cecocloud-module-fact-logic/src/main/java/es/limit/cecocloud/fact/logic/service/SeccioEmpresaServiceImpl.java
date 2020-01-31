/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.SeccioEmpresa;
import es.limit.cecocloud.fact.logic.api.dto.SeccioEmpresa.SeccioEmpresaPk;
import es.limit.cecocloud.fact.logic.api.service.SeccioEmpresaService;
import es.limit.cecocloud.fact.persist.entity.SeccioEmpresaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de provincies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SeccioEmpresaServiceImpl extends AbstractGenericCompositePkServiceImpl<SeccioEmpresa, SeccioEmpresaEntity, SeccioEmpresaPk> implements SeccioEmpresaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected SeccioEmpresaPk getPkFromDto(SeccioEmpresa dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());
		return new SeccioEmpresaPk(
				dto.getIdentificador().getId(),				
				dto.getArticleFamilia().getPk().getCodi(),
				empresa.getEmbedded().getCodi());				
	}

}
