/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.Pais;
import es.limit.cecocloud.ecom.logic.api.service.PaisService;
import es.limit.cecocloud.ecom.persist.entity.PaisEntity;

/**
 * Implementació del servei de gestió de Pais
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomPaisService")
public class PaisServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Pais, PaisEntity, String> implements PaisService {

}
