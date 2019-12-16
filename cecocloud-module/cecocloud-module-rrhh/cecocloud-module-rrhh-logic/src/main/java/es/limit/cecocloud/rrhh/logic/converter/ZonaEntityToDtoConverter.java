/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Zona;
import es.limit.cecocloud.rrhh.persist.entity.ZonaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ZonaRrhh.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("rrhhZonaEntityToDtoConverter")
public class ZonaEntityToDtoConverter extends AbstractEntityToDtoConverter<ZonaEntity, Zona> {

}