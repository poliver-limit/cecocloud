/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.Divisa;
import es.limit.cecocloud.ecom.logic.api.service.DivisaService;
import es.limit.cecocloud.ecom.persist.entity.DivisaEntity;

/**
 * Implementació del servei de gestió de divises.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomDivisaService")
public class DivisaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Divisa, DivisaEntity, String> implements DivisaService {

}
