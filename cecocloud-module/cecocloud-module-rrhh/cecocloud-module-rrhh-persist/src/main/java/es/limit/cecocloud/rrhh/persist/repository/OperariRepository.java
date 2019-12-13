/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;
import es.limit.cecocloud.rrhh.persist.entity.OperariEntity;

/**
 * Repositori per a gestionar les entitats de tipus Operari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("OperariRrhhRepository")
public interface OperariRepository extends BaseRepository<OperariEntity, AmbIdentificadorICodiPk<String>> {
}