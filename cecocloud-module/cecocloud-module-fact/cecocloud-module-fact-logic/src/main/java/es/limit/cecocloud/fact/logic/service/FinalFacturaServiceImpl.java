/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.FinalFactura;
import es.limit.cecocloud.fact.logic.api.service.FinalFacturaService;
import es.limit.cecocloud.fact.persist.entity.FinalFacturaEntity;

/**
 * Implementació del servei de gestió de FinalFactura.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FinalFacturaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<FinalFactura, FinalFacturaEntity, String>
		implements FinalFacturaService {

}

