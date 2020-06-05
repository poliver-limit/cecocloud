/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.Transportista;
import es.limit.cecocloud.ecom.logic.api.service.TransportistaService;
import es.limit.cecocloud.ecom.persist.entity.TransportistaEntity;

/**
 * Implementació del servei de gestió de Transportista.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomTransportistaService")
public class TrasnsportistaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Transportista, TransportistaEntity, String> implements TransportistaService {

}
