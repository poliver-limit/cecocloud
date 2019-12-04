/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.Subvencio;
import es.limit.cecocloud.facturacio.logic.api.dto.Subvencio.SubvencioPk;
import es.limit.cecocloud.facturacio.logic.api.service.SubvencioService;
import es.limit.cecocloud.facturacio.persist.entity.SubvencioEntity;

/**
 * Implementació del servei de gestió de subvencions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SubvencioServiceImpl extends AbstractGenericCompositePkServiceImpl<Subvencio, SubvencioEntity, SubvencioPk> implements SubvencioService {

	@Override
	protected SubvencioPk getPkFromDto(Subvencio dto) {
		return new SubvencioPk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
