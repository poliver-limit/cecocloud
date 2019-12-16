/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Calendari;
import es.limit.cecocloud.rrhh.persist.entity.CalendariEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Calendari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class CalendariEntityToDtoConverter extends AbstractEntityToDtoConverter<CalendariEntity, Calendari> {

}