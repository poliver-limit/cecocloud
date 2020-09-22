/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.PreuPerZona;
import es.limit.cecocloud.fact.persist.entity.PreuPerZonaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus PreuPerZona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("factPreuPerZonaEntityToDtoConverter")
public class PreuPerZonaEntityToDtoConverter extends AbstractEntityToDtoConverter<PreuPerZonaEntity, PreuPerZona> {

}