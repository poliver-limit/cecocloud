/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.Iva;
import es.limit.cecocloud.ecom.logic.api.service.IvaService;
import es.limit.cecocloud.ecom.persist.entity.IvaEntity;

/**
 * Implementació del servei de gestió de Iva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomIvaService")
public class IvaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Iva, IvaEntity, String> implements IvaService {

}
