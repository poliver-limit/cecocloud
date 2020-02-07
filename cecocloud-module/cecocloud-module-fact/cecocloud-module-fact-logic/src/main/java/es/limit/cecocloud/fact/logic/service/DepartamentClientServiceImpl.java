/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.DepartamentClient;
import es.limit.cecocloud.fact.logic.api.dto.DepartamentClient.DepartamentClientPk;
import es.limit.cecocloud.fact.logic.api.service.DepartamentClientService;
import es.limit.cecocloud.fact.persist.entity.DepartamentClientEntity;

/**
 * Implementació del servei de gestió de peus document.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class DepartamentClientServiceImpl extends AbstractGenericCompositePkServiceImpl<DepartamentClient, DepartamentClientEntity, DepartamentClientPk> implements DepartamentClientService {

	@Override
	protected DepartamentClientPk getPkFromDto(DepartamentClient dto) {
	
		return new DepartamentClientPk(
				dto.getIdentificador().getId(),
				dto.getClient().getPk().getCodi(),				
				dto.getCodi());
		
	}


}
