/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.RegimIva;
import es.limit.cecocloud.fact.logic.api.service.RegimIvaService;
import es.limit.cecocloud.fact.persist.entity.RegimIvaEntity;

/**
 * Implementació del servei de gestió de regims d'iva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class RegimIvaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<RegimIva, RegimIvaEntity, String> implements RegimIvaService {

}
