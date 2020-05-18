/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.Magatzem;
import es.limit.cecocloud.ecom.logic.api.service.MagatzemService;
import es.limit.cecocloud.ecom.persist.entity.MagatzemEntity;

/**
 * Implementació del servei de gestió de Magatzem.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomMagatzemService")
public class MagatzemServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Magatzem, MagatzemEntity, String> implements MagatzemService {

}
