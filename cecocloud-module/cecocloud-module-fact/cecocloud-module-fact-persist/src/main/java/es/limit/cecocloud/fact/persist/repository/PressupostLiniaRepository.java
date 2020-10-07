/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.PressupostLinia.PressupostLiniaPk;
import es.limit.cecocloud.fact.persist.entity.PressupostLiniaEntity;

/**
 * Repositori per a gestionar les entitats de tipus PressupostLinia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factPressupostLiniaRepository")
public interface PressupostLiniaRepository extends BaseRepository<PressupostLiniaEntity, PressupostLiniaPk> {
}