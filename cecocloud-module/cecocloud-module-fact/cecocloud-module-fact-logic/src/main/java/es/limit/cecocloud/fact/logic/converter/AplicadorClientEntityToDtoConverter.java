/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.AplicadorClient;
import es.limit.cecocloud.fact.persist.entity.AplicadorClientEntity;

/**
 * Conversor cap a DTO de les entitats de tipus AplicadorClient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class AplicadorClientEntityToDtoConverter extends AbstractEntityToDtoConverter<AplicadorClientEntity, AplicadorClient> {

}