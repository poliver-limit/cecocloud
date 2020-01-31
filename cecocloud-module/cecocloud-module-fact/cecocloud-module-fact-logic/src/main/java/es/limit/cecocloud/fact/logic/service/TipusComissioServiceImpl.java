/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.TipusComissio;
import es.limit.cecocloud.fact.logic.api.service.TipusComissioService;
import es.limit.cecocloud.fact.persist.entity.TipusComissioEntity;

/**
 * Implementació del servei de gestió de tipus comissio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusComissioServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusComissio, TipusComissioEntity, String> implements TipusComissioService {

}
