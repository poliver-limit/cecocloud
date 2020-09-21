/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.BusinessGroup;
import es.limit.cecocloud.fact.persist.entity.BusinessGroupEntity;

/**
 * Convert entity to DTO from type BusinessGroup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class BusinessGroupEntityToDtoConverter extends AbstractEntityToDtoConverter<BusinessGroupEntity, BusinessGroup> {

}