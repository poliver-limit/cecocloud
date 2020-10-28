/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.Expedient.ExpedientPk;
import es.limit.cecocloud.fact.persist.entity.ExpedientEntity;

/**
 * Repositori per a gestionar les entitats de tipus Expedient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factExpedientRepository")
public interface ExpedientRepository extends BaseRepository<ExpedientEntity, ExpedientPk> {
}