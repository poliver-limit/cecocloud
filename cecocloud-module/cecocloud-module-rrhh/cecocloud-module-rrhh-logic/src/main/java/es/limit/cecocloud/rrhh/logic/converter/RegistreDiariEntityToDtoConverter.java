/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.RegistreDiari;
import es.limit.cecocloud.rrhh.persist.entity.RegistreDiariEntity;

/**
 * Conversor cap a DTO de les entitats de tipus RegistreDiari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class RegistreDiariEntityToDtoConverter extends AbstractEntityToDtoConverter<RegistreDiariEntity, RegistreDiari> {

}