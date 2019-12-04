/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.CodiPostal;
import es.limit.cecocloud.facturacio.logic.api.dto.CodiPostal.CodiPostalPk;
import es.limit.cecocloud.facturacio.logic.api.service.CodiPostalService;
import es.limit.cecocloud.facturacio.persist.entity.CodiPostalEntity;

/**
 * Implementació del servei de gestió de codis postal.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CodiPostalServiceImpl extends AbstractGenericCompositePkServiceImpl<CodiPostal, CodiPostalEntity, CodiPostalPk> implements CodiPostalService {

	@Override
	protected CodiPostalPk getPkFromDto(CodiPostal dto) {
		return new CodiPostalPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
