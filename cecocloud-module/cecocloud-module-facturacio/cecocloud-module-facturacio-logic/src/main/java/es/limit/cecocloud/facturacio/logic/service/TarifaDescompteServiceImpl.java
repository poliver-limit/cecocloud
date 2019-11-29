/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.TarifaDescompte;
import es.limit.cecocloud.facturacio.logic.api.dto.TarifaDescompte.TarifaDescomptePk;
import es.limit.cecocloud.facturacio.logic.api.service.TarifaDescompteService;
import es.limit.cecocloud.facturacio.persist.entity.TarifaDescompteEntity;

/**
 * Implementació del servei de gestió de tarifes descompte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TarifaDescompteServiceImpl extends AbstractGenericCompositePkServiceImpl<TarifaDescompte, TarifaDescompteEntity, TarifaDescomptePk> implements TarifaDescompteService {

	@Override
	protected TarifaDescomptePk getPkFromDto(TarifaDescompte dto) {
		return new TarifaDescomptePk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
