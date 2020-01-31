/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.facturacio.logic.api.dto.Client;
import es.limit.cecocloud.facturacio.logic.api.service.ClientService;
import es.limit.cecocloud.facturacio.persist.entity.ClientEntity;

/**
 * Implementació del servei de gestió de clients.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ClientServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Client, ClientEntity, String>
		implements ClientService {

}
