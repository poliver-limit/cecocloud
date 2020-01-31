/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Zona;
import es.limit.cecocloud.fact.persist.entity.ZonaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus ZonaFact.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ZonaEntityToDtoConverter extends AbstractEntityToDtoConverter<ZonaEntity, Zona> {

}