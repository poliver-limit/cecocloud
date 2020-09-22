/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Parameter;
import es.limit.cecocloud.fact.persist.entity.ParameterEntity;

/**
 * Convert entity to DTO from type Parameter.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class ParameterEntityToDtoConverter extends AbstractEntityToDtoConverter<ParameterEntity, Parameter> {

}