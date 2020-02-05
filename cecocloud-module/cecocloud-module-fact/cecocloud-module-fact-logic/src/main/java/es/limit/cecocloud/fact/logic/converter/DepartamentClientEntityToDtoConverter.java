/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.DepartamentClient;
import es.limit.cecocloud.fact.persist.entity.DepartamentClientEntity;

/**
 * Conversor cap a DTO de les entitats de tipus DepartamentClient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class DepartamentClientEntityToDtoConverter extends AbstractEntityToDtoConverter<DepartamentClientEntity, DepartamentClient> {

}