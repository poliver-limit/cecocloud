/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.UbicacioArticle.UbicacioArticlePk;
import es.limit.cecocloud.fact.persist.entity.UbicacioArticleEntity;

/**
 * Repositori per a gestionar les entitats de tipus UbicacioArticle.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface UbicacioArticleRepository extends BaseRepository<UbicacioArticleEntity, UbicacioArticlePk> {
}