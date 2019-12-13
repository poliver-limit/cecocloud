/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.PerfilRol;
import es.limit.cecocloud.persist.entity.PerfilRolEntity;

/**
 * Conversor cap a DTO de les entitats de tipus perfilRol.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class PerfilRolEntityToDtoConverter extends AbstractEntityToDtoConverter<PerfilRolEntity, PerfilRol> {

}