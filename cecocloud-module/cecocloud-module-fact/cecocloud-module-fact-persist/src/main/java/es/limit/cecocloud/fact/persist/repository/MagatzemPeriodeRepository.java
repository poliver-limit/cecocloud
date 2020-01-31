/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.MagatzemPeriode.MagatzemPeriodePk;
import es.limit.cecocloud.fact.persist.entity.MagatzemPeriodeEntity;

/**
 * Repositori per a gestionar les entitats de tipus MagatzemPeriode.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface MagatzemPeriodeRepository extends BaseRepository<MagatzemPeriodeEntity, MagatzemPeriodePk> {
}