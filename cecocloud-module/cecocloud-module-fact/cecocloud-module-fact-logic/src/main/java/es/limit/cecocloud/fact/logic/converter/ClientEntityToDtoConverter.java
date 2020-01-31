/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Client;
import es.limit.cecocloud.fact.persist.entity.ClientEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ClientEntityToDtoConverter extends AbstractEntityToDtoConverter<ClientEntity, Client> {

}
