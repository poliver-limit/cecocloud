/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Ubicacio;
import es.limit.cecocloud.fact.persist.entity.UbicacioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Ubicacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class UbicacioEntityToDtoConverter extends AbstractEntityToDtoConverter<UbicacioEntity, Ubicacio> {

}