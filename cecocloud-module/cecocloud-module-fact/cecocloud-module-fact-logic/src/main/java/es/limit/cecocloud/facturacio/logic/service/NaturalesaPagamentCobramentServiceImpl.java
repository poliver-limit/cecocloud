/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.NaturalesaPagamentCobrament;
import es.limit.cecocloud.facturacio.logic.api.service.NaturalesaPagamentCobramentService;
import es.limit.cecocloud.facturacio.persist.entity.NaturalesaPagamentCobramentEntity;

/**
 * Implementació del servei de gestió de Naturaleses Pagament/Cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class NaturalesaPagamentCobramentServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<NaturalesaPagamentCobrament, NaturalesaPagamentCobramentEntity, String> implements NaturalesaPagamentCobramentService {

}
