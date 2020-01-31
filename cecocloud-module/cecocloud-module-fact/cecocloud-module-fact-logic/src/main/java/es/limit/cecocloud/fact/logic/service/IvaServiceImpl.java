/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.Iva;
import es.limit.cecocloud.fact.logic.api.service.IvaService;
import es.limit.cecocloud.fact.persist.entity.IvaEntity;

/**
 * Implementació del servei de gestió de Iva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class IvaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Iva, IvaEntity, String> implements IvaService {

}
