/**
 * 
 */
package es.limit.cecocloud.cita.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.cita.logic.api.dto.Cita;
import es.limit.cecocloud.cita.persist.entity.CitaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus cita.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class CitaEntityToDtoConverter extends AbstractEntityToDtoConverter<CitaEntity, Cita> {

}
