/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.Rol;
import es.limit.cecocloud.persist.entity.RolEntity;

/**
 * Conversor cap a DTO de les entitats de tipus rol.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class RolEntityToDtoConverter extends AbstractEntityToDtoConverter<RolEntity, Rol> {

}