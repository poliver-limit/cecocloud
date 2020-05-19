/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.ecom.logic.api.dto.Client;
import es.limit.cecocloud.ecom.logic.api.service.ClientService;
import es.limit.cecocloud.ecom.persist.entity.ClientEntity;

/**
 * Implementació del servei de gestió de Client
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomClientService")
public class ClientServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Client, ClientEntity, String> implements ClientService {

}
