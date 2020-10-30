/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.fact.logic.api.dto.TarifaProveidor;
import es.limit.cecocloud.fact.logic.api.dto.TarifaProveidor.TarifaProveidorPk;
import es.limit.cecocloud.fact.logic.api.service.TarifaProveidorService;
import es.limit.cecocloud.fact.persist.entity.TarifaProveidorEntity;


/**
 * Implementació del servei de gestió de TarifaProveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TarifaProveidorServiceImpl extends AbstractGenericCompositePkServiceImpl<TarifaProveidor, TarifaProveidorEntity, TarifaProveidorPk> implements TarifaProveidorService {
	
	@Override
	protected TarifaProveidorPk getPkFromDto(TarifaProveidor dto) {			
		return new TarifaProveidorPk(
				dto.getIdentificador().getId(),		
				dto.getProveidor().getPk().getCodi(),				
				dto.getCodi());
	}

}
