/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.Taller.TallerPk;
import es.limit.cecocloud.fact.persist.entity.TallerEntity;

/**
 * Repositori per a gestionar les entitats de tipus Taller.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factTallerRepository")
public interface TallerRepository extends BaseRepository<TallerEntity, TallerPk> {
}