/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.Transportista;
import es.limit.cecocloud.fact.logic.api.service.TransportistaService;
import es.limit.cecocloud.fact.persist.entity.TransportistaEntity;

/**
 * Implementació del servei de gestió de transportistes.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TransportistaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Transportista, TransportistaEntity, String> implements TransportistaService {

}
