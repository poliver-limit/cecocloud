/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemPeriode.MagatzemPeriodePk;
import es.limit.cecocloud.ecom.persist.entity.MagatzemPeriodeEntity;

/**
 * Repositori per a gestionar les entitats de tipus MagatzemPeriode.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomMagatzemPeriodeRepository")
public interface MagatzemPeriodeRepository extends BaseRepository<MagatzemPeriodeEntity, MagatzemPeriodePk> {
}