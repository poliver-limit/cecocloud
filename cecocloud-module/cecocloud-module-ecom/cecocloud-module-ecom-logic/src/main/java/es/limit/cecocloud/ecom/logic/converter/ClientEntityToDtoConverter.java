/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Client;
import es.limit.cecocloud.ecom.persist.entity.ClientEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomClientEntityToDtoConverter")
public class ClientEntityToDtoConverter extends AbstractEntityToDtoConverter<ClientEntity, Client> {

}