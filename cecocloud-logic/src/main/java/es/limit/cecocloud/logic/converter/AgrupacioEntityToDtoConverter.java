/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.Agrupacio;
import es.limit.cecocloud.persist.entity.AgrupacioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus agrupacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class AgrupacioEntityToDtoConverter extends AbstractEntityToDtoConverter<AgrupacioEntity, Agrupacio> {

}