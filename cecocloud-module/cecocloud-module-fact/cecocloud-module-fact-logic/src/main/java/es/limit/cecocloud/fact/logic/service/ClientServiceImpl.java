/**
 * 
 */
package es.limit.cecocloud.fact.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.fact.logic.api.dto.Client;
import es.limit.cecocloud.fact.logic.api.service.ClientService;
import es.limit.cecocloud.fact.persist.entity.ClientEntity;

/**
 * Implementació del servei de gestió de clients.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ClientServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Client, ClientEntity, String>
		implements ClientService {

}
