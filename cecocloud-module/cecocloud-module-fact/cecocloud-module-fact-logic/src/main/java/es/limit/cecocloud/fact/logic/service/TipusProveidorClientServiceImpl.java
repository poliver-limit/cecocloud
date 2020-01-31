/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.TipusProveidorClient;
import es.limit.cecocloud.fact.logic.api.service.TipusProveidorClientService;
import es.limit.cecocloud.fact.persist.entity.TipusProveidorClientEntity;

/**
 * Implementació del servei de gestió de tipus proveidor client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class TipusProveidorClientServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<TipusProveidorClient, TipusProveidorClientEntity, String> implements TipusProveidorClientService {

}
