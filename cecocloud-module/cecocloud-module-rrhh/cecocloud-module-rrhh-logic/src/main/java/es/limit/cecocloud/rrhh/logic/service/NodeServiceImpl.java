/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.Node;
import es.limit.cecocloud.rrhh.logic.api.dto.Node.NodePk;
import es.limit.cecocloud.rrhh.logic.api.service.NodeService;
import es.limit.cecocloud.rrhh.persist.entity.NodeEntity;

/**
 * Implementació del servei de gestió de nodes.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class NodeServiceImpl extends AbstractGenericCompositePkServiceImpl<Node, NodeEntity, NodePk> implements NodeService {

	@Override
	protected NodePk getPkFromDto(Node dto) {
		return new NodePk(
				dto.getIdentificador().getId(),
				dto.getNumero());
	}

}
