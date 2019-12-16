/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Seccio;
import es.limit.cecocloud.rrhh.persist.entity.SeccioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Seccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class SeccioEntityToDtoConverter extends AbstractEntityToDtoConverter<SeccioEntity, Seccio> {

}