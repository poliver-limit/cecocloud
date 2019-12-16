/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.ZonaFact;
import es.limit.cecocloud.facturacio.logic.api.dto.ZonaFact.ZonaFactPk;
import es.limit.cecocloud.facturacio.logic.api.service.ZonaFactService;
import es.limit.cecocloud.facturacio.persist.entity.ZonaFactEntity;

/**
 * Implementació del servei de gestió de zones.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ZonaFactService")
public class ZonaFactServiceImpl extends AbstractGenericCompositePkServiceImpl<ZonaFact, ZonaFactEntity, ZonaFactPk> implements ZonaFactService {

	@Override
	protected ZonaFactPk getPkFromDto(ZonaFact dto) {
		return new ZonaFactPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
