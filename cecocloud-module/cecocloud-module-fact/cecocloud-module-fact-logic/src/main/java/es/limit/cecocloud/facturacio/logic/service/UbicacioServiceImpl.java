/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.Ubicacio;
import es.limit.cecocloud.facturacio.logic.api.dto.Ubicacio.UbicacioPk;
import es.limit.cecocloud.facturacio.logic.api.service.UbicacioService;
import es.limit.cecocloud.facturacio.persist.entity.UbicacioEntity;

/**
 * Implementació del servei de gestió de provincies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class UbicacioServiceImpl extends AbstractGenericCompositePkServiceImpl<Ubicacio, UbicacioEntity, UbicacioPk> implements UbicacioService {

	@Override
	protected UbicacioPk getPkFromDto(Ubicacio dto) {
		return new UbicacioPk(
				dto.getIdentificador().getId(),				
				dto.getMagatzem().getPk().getCodi(),
				dto.getCodi());
	}


}
