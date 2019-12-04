/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.MagatzemPeriode.MagatzemPeriodePk;
import es.limit.cecocloud.facturacio.persist.entity.MagatzemPeriodeEntity;

/**
 * Repositori per a gestionar les entitats de tipus MagatzemPeriode.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface MagatzemPeriodeRepository extends BaseRepository<MagatzemPeriodeEntity, MagatzemPeriodePk> {
}