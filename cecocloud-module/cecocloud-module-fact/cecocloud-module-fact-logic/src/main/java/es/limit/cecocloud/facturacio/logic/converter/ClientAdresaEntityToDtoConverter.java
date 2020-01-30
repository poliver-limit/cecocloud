/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.ClientAdresa;
import es.limit.cecocloud.facturacio.persist.entity.ClientAdresaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ClientAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ClientAdresaEntityToDtoConverter extends AbstractEntityToDtoConverter<ClientAdresaEntity, ClientAdresa> {

}
