/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.SerieIntracomunitaria;
import es.limit.cecocloud.fact.logic.api.dto.SerieIntracomunitaria.SerieIntracomunitariaPk;
import es.limit.cecocloud.fact.logic.api.service.SerieIntracomunitariaService;
import es.limit.cecocloud.fact.persist.entity.SerieIntracomunitariaEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.repository.EmpresaRepository;

/**
 * Implementació del servei de gestió de series intracomunitaries.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SerieIntracomunitariaServiceImpl extends AbstractGenericCompositePkServiceImpl<SerieIntracomunitaria, SerieIntracomunitariaEntity, SerieIntracomunitariaPk> implements SerieIntracomunitariaService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	protected SerieIntracomunitariaPk getPkFromDto(SerieIntracomunitaria dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();		
		EmpresaEntity empresa = empresaRepository.getOne(userSession.getE());	
		return new SerieIntracomunitariaPk(
				dto.getIdentificador().getId(),
				empresa.getEmbedded().getCodi(),
				dto.getCodi());
				
	}

}