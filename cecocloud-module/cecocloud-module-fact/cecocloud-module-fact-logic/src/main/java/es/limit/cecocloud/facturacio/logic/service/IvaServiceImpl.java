/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.Iva;
import es.limit.cecocloud.facturacio.logic.api.service.IvaService;
import es.limit.cecocloud.facturacio.persist.entity.IvaEntity;

/**
 * Implementació del servei de gestió de Iva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class IvaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Iva, IvaEntity, String> implements IvaService {

}
