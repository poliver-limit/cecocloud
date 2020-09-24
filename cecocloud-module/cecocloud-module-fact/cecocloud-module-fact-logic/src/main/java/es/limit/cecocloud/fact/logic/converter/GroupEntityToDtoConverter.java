/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Group;
import es.limit.cecocloud.fact.persist.entity.GroupEntity;

/**
 * Convert entity to DTO from type Group.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class GroupEntityToDtoConverter extends AbstractEntityToDtoConverter<GroupEntity, Group> {

}