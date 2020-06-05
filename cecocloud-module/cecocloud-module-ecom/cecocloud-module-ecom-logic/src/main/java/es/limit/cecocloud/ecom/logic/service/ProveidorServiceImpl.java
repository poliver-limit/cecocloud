/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.Proveidor;
import es.limit.cecocloud.ecom.logic.api.service.ProveidorService;
import es.limit.cecocloud.ecom.persist.entity.ProveidorEntity;

/**
 * Implementació del servei de gestió de Proveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomProveidorService")
public class ProveidorServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Proveidor, ProveidorEntity, String> implements ProveidorService {

}
