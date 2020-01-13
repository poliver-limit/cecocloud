/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;
//import es.limit.cecocloud.rrhh.logic.api.dto.Node.NodePk;
import es.limit.cecocloud.rrhh.persist.entity.NodeEntity;

/**
 * Repositori per a gestionar les entitats de tipus Node.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
//public interface NodeRepository extends BaseRepository<NodeEntity, NodePk> {
public interface NodeRepository extends BaseRepository<NodeEntity, AmbIdentificadorICodiPk<String>> {
}