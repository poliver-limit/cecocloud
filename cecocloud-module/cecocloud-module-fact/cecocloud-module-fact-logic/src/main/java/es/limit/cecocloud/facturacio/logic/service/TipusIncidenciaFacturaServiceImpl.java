/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusIncidenciaFactura;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusIncidenciaFactura.TipusIncidenciaFacturaPk;
import es.limit.cecocloud.facturacio.logic.api.service.TipusIncidenciaFacturaService;
import es.limit.cecocloud.facturacio.persist.entity.TipusIncidenciaFacturaEntity;

/**
 * Implementació del servei de gestió de tipus incidencia factura.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusIncidenciaFacturaServiceImpl extends AbstractGenericCompositePkServiceImpl<TipusIncidenciaFactura, TipusIncidenciaFacturaEntity, TipusIncidenciaFacturaPk> implements TipusIncidenciaFacturaService {

	@Override
	protected TipusIncidenciaFacturaPk getPkFromDto(TipusIncidenciaFactura dto) {
		return new TipusIncidenciaFacturaPk(
				dto.getIdentificador().getId(),				
				dto.getCodi());
	}


}
