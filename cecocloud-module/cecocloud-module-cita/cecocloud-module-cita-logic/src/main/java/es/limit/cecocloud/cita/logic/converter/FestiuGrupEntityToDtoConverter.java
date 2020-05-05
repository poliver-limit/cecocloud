/**
 * 
 */
package es.limit.cecocloud.cita.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.cita.logic.api.dto.FestiuGrup;
import es.limit.cecocloud.cita.persist.entity.FestiuGrupEntity;

/**
 * Conversor cap a DTO de les entitats de tipus grup de festius.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class FestiuGrupEntityToDtoConverter extends AbstractEntityToDtoConverter<FestiuGrupEntity, FestiuGrup> {

}
