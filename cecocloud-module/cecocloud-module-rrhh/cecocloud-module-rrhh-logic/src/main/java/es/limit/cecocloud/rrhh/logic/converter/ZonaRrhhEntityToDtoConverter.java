/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.ZonaRrhh;
import es.limit.cecocloud.rrhh.persist.entity.ZonaRrhhEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ZonaRrhh.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ZonaRrhhEntityToDtoConverter extends AbstractEntityToDtoConverter<ZonaRrhhEntity, ZonaRrhh> {

}