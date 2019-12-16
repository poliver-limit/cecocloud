/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.UsuariIdentificador;
import es.limit.cecocloud.persist.entity.UsuariIdentificadorEntity;

/**
 * Conversor cap a DTO de les entitats de tipus usuariIdentificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class UsuariIdentificadorEntityToDtoConverter extends AbstractEntityToDtoConverter<UsuariIdentificadorEntity, UsuariIdentificador> {

}