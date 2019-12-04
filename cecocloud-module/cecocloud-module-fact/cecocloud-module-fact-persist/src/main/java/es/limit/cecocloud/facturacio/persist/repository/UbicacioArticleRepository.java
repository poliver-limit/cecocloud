/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.UbicacioArticle.UbicacioArticlePk;
import es.limit.cecocloud.facturacio.persist.entity.UbicacioArticleEntity;

/**
 * Repositori per a gestionar les entitats de tipus UbicacioArticle.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface UbicacioArticleRepository extends BaseRepository<UbicacioArticleEntity, UbicacioArticlePk> {
}