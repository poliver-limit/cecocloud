/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.TipusUnitat;
import es.limit.cecocloud.ecom.logic.api.service.TipusUnitatService;
import es.limit.cecocloud.ecom.persist.entity.TipusUnitatEntity;

/**
 * Implementació del servei de gestió de TipusUnitat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomTipusUnitatService")
public class TipusUnitatServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusUnitat, TipusUnitatEntity, String> implements TipusUnitatService {

}
