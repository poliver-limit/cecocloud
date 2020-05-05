/**
 * 
 */
package es.limit.cecocloud.cita.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.cita.logic.api.dto.HorariInterval;
import es.limit.cecocloud.cita.persist.entity.HorariIntervalEntity;

/**
 * Conversor cap a DTO de les entitats de tipus interval horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class HorariIntervalEntityToDtoConverter extends AbstractEntityToDtoConverter<HorariIntervalEntity, HorariInterval> {

}
