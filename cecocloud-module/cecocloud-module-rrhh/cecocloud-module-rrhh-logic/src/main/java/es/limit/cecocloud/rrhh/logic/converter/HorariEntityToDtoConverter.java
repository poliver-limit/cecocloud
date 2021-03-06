/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Horari;
import es.limit.cecocloud.rrhh.persist.entity.HorariEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class HorariEntityToDtoConverter extends AbstractEntityToDtoConverter<HorariEntity, Horari> {

}