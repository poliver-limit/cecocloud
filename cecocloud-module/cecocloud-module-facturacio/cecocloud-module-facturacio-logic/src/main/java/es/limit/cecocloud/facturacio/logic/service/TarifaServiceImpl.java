/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.Tarifa;
import es.limit.cecocloud.facturacio.logic.api.dto.Tarifa.TarifaPk;
import es.limit.cecocloud.facturacio.logic.api.service.TarifaService;
import es.limit.cecocloud.facturacio.persist.entity.TarifaEntity;

/**
 * Implementació del servei de gestió de tarifes.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TarifaServiceImpl extends AbstractGenericCompositePkServiceImpl<Tarifa, TarifaEntity, TarifaPk> implements TarifaService {

	@Override
	protected TarifaPk getPkFromDto(Tarifa dto) {
		return new TarifaPk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
