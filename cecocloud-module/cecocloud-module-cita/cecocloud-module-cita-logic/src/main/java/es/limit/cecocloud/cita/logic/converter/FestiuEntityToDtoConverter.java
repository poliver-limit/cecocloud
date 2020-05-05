/**
 * 
 */
package es.limit.cecocloud.cita.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.cita.logic.api.dto.Festiu;
import es.limit.cecocloud.cita.persist.entity.FestiuEntity;

/**
 * Conversor cap a DTO de les entitats de tipus festiu.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class FestiuEntityToDtoConverter extends AbstractEntityToDtoConverter<FestiuEntity, Festiu> {

}
