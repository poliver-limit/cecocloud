/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.TipusVenciment;
import es.limit.cecocloud.ecom.logic.api.service.TipusVencimentService;
import es.limit.cecocloud.ecom.persist.entity.TipusVencimentEntity;

/**
 * Implementació del servei de gestió de TipusVenciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomTipusVencimentService")
public class TipusVencimentServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusVenciment, TipusVencimentEntity, String> implements TipusVencimentService {

}
