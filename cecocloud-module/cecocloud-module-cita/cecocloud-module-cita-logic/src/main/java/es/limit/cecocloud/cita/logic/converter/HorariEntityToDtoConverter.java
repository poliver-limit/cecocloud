/**
 * 
 */
package es.limit.cecocloud.cita.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.cita.logic.api.dto.Horari;
import es.limit.cecocloud.cita.persist.entity.HorariEntity;

/**
 * Conversor cap a DTO de les entitats de tipus horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("citaHorariEntityToDtoConverter")
public class HorariEntityToDtoConverter extends AbstractEntityToDtoConverter<HorariEntity, Horari> {

}
