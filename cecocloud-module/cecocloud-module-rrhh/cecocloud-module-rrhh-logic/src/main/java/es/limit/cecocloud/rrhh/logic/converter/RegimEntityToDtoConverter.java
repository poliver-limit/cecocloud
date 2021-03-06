/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Regim;
import es.limit.cecocloud.rrhh.persist.entity.RegimEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Regim.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class RegimEntityToDtoConverter extends AbstractEntityToDtoConverter<RegimEntity, Regim> {

}