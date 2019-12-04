/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusComissio;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusComissio.TipusComissioPk;
import es.limit.cecocloud.facturacio.logic.api.service.TipusComissioService;
import es.limit.cecocloud.facturacio.persist.entity.TipusComissioEntity;

/**
 * Implementació del servei de gestió de tipus comissio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusComissioServiceImpl extends AbstractGenericCompositePkServiceImpl<TipusComissio, TipusComissioEntity, TipusComissioPk> implements TipusComissioService {

	@Override
	protected TipusComissioPk getPkFromDto(TipusComissio dto) {
		return new TipusComissioPk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
