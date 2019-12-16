/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.TipusRisc;
import es.limit.cecocloud.facturacio.logic.api.service.TipusRiscService;
import es.limit.cecocloud.facturacio.persist.entity.TipusRiscEntity;

/**
 * Implementació del servei de gestió de tipus risc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusRiscServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusRisc, TipusRiscEntity, String> implements TipusRiscService {

}
