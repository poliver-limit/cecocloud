/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.PreuPerGamma.PreuPerGammaPk;
import es.limit.cecocloud.fact.persist.entity.PreuPerGammaEntity;

/**
 * Repositori per a gestionar les entitats de tipus PreuPerGamma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factPreuPerGammaRepository")
public interface PreuPerGammaRepository extends BaseRepository<PreuPerGammaEntity, PreuPerGammaPk> {
}