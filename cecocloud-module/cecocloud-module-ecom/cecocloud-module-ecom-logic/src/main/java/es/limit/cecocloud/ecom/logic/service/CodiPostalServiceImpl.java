/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.CodiPostal;
import es.limit.cecocloud.ecom.logic.api.service.CodiPostalService;
import es.limit.cecocloud.ecom.persist.entity.CodiPostalEntity;

/**
 * Implementació del servei de gestió de CodiPostal.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomCodiPostalService")
public class CodiPostalServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<CodiPostal, CodiPostalEntity, String> implements CodiPostalService {

}
