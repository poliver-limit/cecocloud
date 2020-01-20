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
import es.limit.cecocloud.rrhh.logic.api.dto.SeccioGrup;
import es.limit.cecocloud.rrhh.logic.api.dto.SeccioGrup.SeccioGrupPk;
import es.limit.cecocloud.rrhh.logic.api.service.SeccioGrupService;
import es.limit.cecocloud.rrhh.persist.entity.SeccioGrupEntity;

/**
 * Implementació del servei de gestió de seccions grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SeccioGrupServiceImpl extends AbstractGenericCompositePkServiceImpl<SeccioGrup, SeccioGrupEntity, SeccioGrupPk> implements SeccioGrupService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected SeccioGrupPk getPkFromDto(SeccioGrup dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new SeccioGrupPk(
				dto.getIdentificador().getId(),
				empresa.getEmbedded().getCodi(),
				dto.getCodi());
	}

}
