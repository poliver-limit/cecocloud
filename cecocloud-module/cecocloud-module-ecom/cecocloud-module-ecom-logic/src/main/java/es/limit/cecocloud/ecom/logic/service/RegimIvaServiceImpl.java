/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.RegimIva;
import es.limit.cecocloud.ecom.logic.api.service.RegimIvaService;
import es.limit.cecocloud.ecom.persist.entity.RegimIvaEntity;

/**
 * Implementació del servei de gestió de RegimIva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomRegimIvaService")
public class RegimIvaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<RegimIva, RegimIvaEntity, String> implements RegimIvaService {

}
