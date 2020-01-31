/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.CodiPostal;
import es.limit.cecocloud.fact.logic.api.service.CodiPostalService;
import es.limit.cecocloud.fact.persist.entity.CodiPostalEntity;

/**
 * Implementació del servei de gestió de codis postal.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CodiPostalServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<CodiPostal, CodiPostalEntity, String> implements CodiPostalService {

}
