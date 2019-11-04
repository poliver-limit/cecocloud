/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;

/**
 * Conversor cap a DTO de les entitats de tipus identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class IdentificadorEntityToDtoConverter extends AbstractEntityToDtoConverter<IdentificadorEntity, Identificador> {

}