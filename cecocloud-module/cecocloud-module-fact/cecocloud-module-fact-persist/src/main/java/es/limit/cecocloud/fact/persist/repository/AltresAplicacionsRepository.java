/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.AltresAplicacions.AltresAplicacionsPk;
import es.limit.cecocloud.fact.persist.entity.AltresAplicacionsEntity;

/**
 * Repositori per a gestionar les entitats de tipus AltresAplicacions.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factAltresAplicacionsRepository")
public interface AltresAplicacionsRepository extends BaseRepository<AltresAplicacionsEntity, AltresAplicacionsPk> {
}