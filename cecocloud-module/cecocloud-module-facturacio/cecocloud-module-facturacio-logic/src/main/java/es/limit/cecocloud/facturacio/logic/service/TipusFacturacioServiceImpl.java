/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusFacturacio;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusFacturacio.TipusFacturacioPk;
import es.limit.cecocloud.facturacio.logic.api.service.TipusFacturacioService;
import es.limit.cecocloud.facturacio.persist.entity.TipusFacturacioEntity;

/**
 * Implementació del servei de gestió de tipus facturacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusFacturacioServiceImpl extends AbstractGenericCompositePkServiceImpl<TipusFacturacio, TipusFacturacioEntity, TipusFacturacioPk> implements TipusFacturacioService {

	@Override
	protected TipusFacturacioPk getPkFromDto(TipusFacturacio dto) {
		return new TipusFacturacioPk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
