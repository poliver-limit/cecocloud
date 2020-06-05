/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.FamiliaProveidor;
import es.limit.cecocloud.ecom.logic.api.service.FamiliaProveidorService;
import es.limit.cecocloud.ecom.persist.entity.FamiliaProveidorEntity;

/**
 * Implementació del servei de gestió de FamiliaProveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomFamiliaProveidorService")
public class FamiliaProveidorServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<FamiliaProveidor, FamiliaProveidorEntity, String> implements FamiliaProveidorService {

}
