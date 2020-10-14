/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.MantenimentDeTipusEntity;

/**
 * Repositori per a gestionar les entitats de tipus MantenimentDeTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factMantenimentDeTipusRepository")
public interface MantenimentDeTipusRepository extends BaseRepository<MantenimentDeTipusEntity, WithIdentificadorAndCodiPk<String>> {
}