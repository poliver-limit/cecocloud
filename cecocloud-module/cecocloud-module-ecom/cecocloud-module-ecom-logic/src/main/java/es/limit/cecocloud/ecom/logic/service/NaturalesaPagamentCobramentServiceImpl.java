/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.NaturalesaPagamentCobrament;
import es.limit.cecocloud.ecom.logic.api.service.NaturalesaPagamentCobramentService;
import es.limit.cecocloud.ecom.persist.entity.NaturalesaPagamentCobramentEntity;

/**
 * Implementació del servei de gestió de Naturaleses Pagament/Cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomNaturalesaPagamentCobramentService")
public class NaturalesaPagamentCobramentServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<NaturalesaPagamentCobrament, NaturalesaPagamentCobramentEntity, String> implements NaturalesaPagamentCobramentService {

}
