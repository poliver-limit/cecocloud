/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusRisc;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusRisc.TipusRiscPk;
import es.limit.cecocloud.facturacio.logic.api.service.TipusRiscService;
import es.limit.cecocloud.facturacio.persist.entity.TipusRiscEntity;

/**
 * Implementació del servei de gestió de tipus risc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusRiscServiceImpl extends AbstractGenericCompositePkServiceImpl<TipusRisc, TipusRiscEntity, TipusRiscPk> implements TipusRiscService {

	@Override
	protected TipusRiscPk getPkFromDto(TipusRisc dto) {
		return new TipusRiscPk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
