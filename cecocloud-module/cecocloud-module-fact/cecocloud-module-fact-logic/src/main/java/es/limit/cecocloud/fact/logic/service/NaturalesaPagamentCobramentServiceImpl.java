/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.NaturalesaPagamentCobrament;
import es.limit.cecocloud.fact.logic.api.service.NaturalesaPagamentCobramentService;
import es.limit.cecocloud.fact.persist.entity.NaturalesaPagamentCobramentEntity;

/**
 * Implementació del servei de gestió de Naturaleses Pagament/Cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class NaturalesaPagamentCobramentServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<NaturalesaPagamentCobrament, NaturalesaPagamentCobramentEntity, String> implements NaturalesaPagamentCobramentService {

}
