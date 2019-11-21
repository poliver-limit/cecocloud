/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.UnitatTipus;
import es.limit.cecocloud.facturacio.logic.api.dto.UnitatTipus.UnitatTipusPk;
import es.limit.cecocloud.facturacio.logic.api.service.UnitatTipusService;
import es.limit.cecocloud.facturacio.persist.entity.UnitatTipusEntity;

/**
 * Implementació del servei de gestió de unitats tipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class UnitatTipusServiceImpl extends AbstractGenericCompositePkServiceImpl<UnitatTipus, UnitatTipusEntity, UnitatTipusPk> implements UnitatTipusService {

	@Override
	protected UnitatTipusPk getPkFromDto(UnitatTipus dto) {
		return new UnitatTipusPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
