/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.RegimIva;
import es.limit.cecocloud.facturacio.logic.api.dto.RegimIva.RegimIvaPk;
import es.limit.cecocloud.facturacio.logic.api.service.RegimIvaService;
import es.limit.cecocloud.facturacio.persist.entity.RegimIvaEntity;

/**
 * Implementació del servei de gestió de regims d'iva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class RegimIvaServiceImpl extends AbstractGenericCompositePkServiceImpl<RegimIva, RegimIvaEntity, RegimIvaPk> implements RegimIvaService {

	@Override
	protected RegimIvaPk getPkFromDto(RegimIva dto) {
		return new RegimIvaPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
