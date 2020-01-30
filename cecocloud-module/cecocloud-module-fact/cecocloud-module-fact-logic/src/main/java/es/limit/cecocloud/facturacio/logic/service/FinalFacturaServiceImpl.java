/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.FinalFactura;
import es.limit.cecocloud.facturacio.logic.api.service.FinalFacturaService;
import es.limit.cecocloud.facturacio.persist.entity.FinalFacturaEntity;

/**
 * Implementació del servei de gestió de FinalFactura.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class FinalFacturaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<FinalFactura, FinalFacturaEntity, String>
		implements FinalFacturaService {

}

