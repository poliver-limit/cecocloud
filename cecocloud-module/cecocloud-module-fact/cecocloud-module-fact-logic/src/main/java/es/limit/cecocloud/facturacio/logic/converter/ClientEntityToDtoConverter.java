/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.Client;
import es.limit.cecocloud.facturacio.persist.entity.ClientEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ClientEntityToDtoConverter extends AbstractEntityToDtoConverter<ClientEntity, Client> {

}
