/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.TipusRisc;
import es.limit.cecocloud.ecom.logic.api.service.TipusRiscService;
import es.limit.cecocloud.ecom.persist.entity.TipusRiscEntity;

/**
 * Implementació del servei de gestió de TipusRisc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomTipusRiscService")
public class TipusRiscServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusRisc, TipusRiscEntity, String> implements TipusRiscService {

}
