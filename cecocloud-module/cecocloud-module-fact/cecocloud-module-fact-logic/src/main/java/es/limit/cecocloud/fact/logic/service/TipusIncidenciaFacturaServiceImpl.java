/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.TipusIncidenciaFactura;
import es.limit.cecocloud.fact.logic.api.service.TipusIncidenciaFacturaService;
import es.limit.cecocloud.fact.persist.entity.TipusIncidenciaFacturaEntity;

/**
 * Implementació del servei de gestió de tipus incidencia factura.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusIncidenciaFacturaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusIncidenciaFactura, TipusIncidenciaFacturaEntity, String> implements TipusIncidenciaFacturaService {

}
