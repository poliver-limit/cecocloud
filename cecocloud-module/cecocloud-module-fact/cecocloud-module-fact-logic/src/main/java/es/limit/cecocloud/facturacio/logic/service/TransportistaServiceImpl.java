/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.Transportista;
import es.limit.cecocloud.facturacio.logic.api.service.TransportistaService;
import es.limit.cecocloud.facturacio.persist.entity.TransportistaEntity;

/**
 * Implementació del servei de gestió de transportistes.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TransportistaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Transportista, TransportistaEntity, String> implements TransportistaService {

}
