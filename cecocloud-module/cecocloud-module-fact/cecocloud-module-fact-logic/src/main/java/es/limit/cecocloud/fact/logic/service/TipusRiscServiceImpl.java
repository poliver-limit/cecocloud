/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.TipusRisc;
import es.limit.cecocloud.fact.logic.api.service.TipusRiscService;
import es.limit.cecocloud.fact.persist.entity.TipusRiscEntity;

/**
 * Implementació del servei de gestió de tipus risc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusRiscServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusRisc, TipusRiscEntity, String> implements TipusRiscService {

}
