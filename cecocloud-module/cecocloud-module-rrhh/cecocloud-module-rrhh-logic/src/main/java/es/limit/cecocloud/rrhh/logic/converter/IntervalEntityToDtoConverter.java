/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Interval;
import es.limit.cecocloud.rrhh.persist.entity.IntervalEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Interval.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class IntervalEntityToDtoConverter extends AbstractEntityToDtoConverter<IntervalEntity, Interval> {

}