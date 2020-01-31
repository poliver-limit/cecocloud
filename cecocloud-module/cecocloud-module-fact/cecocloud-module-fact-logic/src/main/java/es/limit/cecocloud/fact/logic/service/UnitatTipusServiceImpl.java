/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.UnitatTipus;
import es.limit.cecocloud.fact.logic.api.service.UnitatTipusService;
import es.limit.cecocloud.fact.persist.entity.UnitatTipusEntity;

/**
 * Implementació del servei de gestió de unitats tipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class UnitatTipusServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<UnitatTipus, UnitatTipusEntity, String> implements UnitatTipusService {

}
