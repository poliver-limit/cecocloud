/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.LiniaFullFeina.LiniaFullFeinaPk;
import es.limit.cecocloud.fact.persist.entity.LiniaFullFeinaEntity;

/**
 * Repositori per a gestionar les entitats de tipus LiniaFullFeina.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factLiniaFullFeinaRepository")
public interface LiniaFullFeinaRepository extends BaseRepository<LiniaFullFeinaEntity, LiniaFullFeinaPk> {
}