/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Parameter;
import es.limit.cecocloud.ecom.persist.entity.ParameterEntity;

/**
 * Convert entity to DTO from type Parameter.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomParameterEntityToDtoConverter")
public class ParameterEntityToDtoConverter extends AbstractEntityToDtoConverter<ParameterEntity, Parameter> {

}