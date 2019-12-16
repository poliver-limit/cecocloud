/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.TipusIncidenciaFactura;
import es.limit.cecocloud.facturacio.logic.api.service.TipusIncidenciaFacturaService;
import es.limit.cecocloud.facturacio.persist.entity.TipusIncidenciaFacturaEntity;

/**
 * Implementació del servei de gestió de tipus incidencia factura.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusIncidenciaFacturaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusIncidenciaFactura, TipusIncidenciaFacturaEntity, String> implements TipusIncidenciaFacturaService {

}
