/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Node;
import es.limit.cecocloud.rrhh.persist.entity.NodeEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Node.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class NodeEntityToDtoConverter extends AbstractEntityToDtoConverter<NodeEntity, Node> {

}