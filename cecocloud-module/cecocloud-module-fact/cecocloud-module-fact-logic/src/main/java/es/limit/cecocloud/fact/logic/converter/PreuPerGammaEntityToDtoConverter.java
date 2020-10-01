/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.PreuPerGamma;
import es.limit.cecocloud.fact.persist.entity.PreuPerGammaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus PreuPerGamma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("factPreuPerGammaEntityToDtoConverter")
public class PreuPerGammaEntityToDtoConverter extends AbstractEntityToDtoConverter<PreuPerGammaEntity, PreuPerGamma> {

}