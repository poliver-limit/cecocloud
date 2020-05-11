/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleTraduccio.ArticleTraduccioPk;
import es.limit.cecocloud.ecom.persist.entity.ArticleTraduccioEntity;

/**
 * Repositori per a gestionar les entitats de tipus ArticleTraduccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomArticleTraduccioRepository")
public interface ArticleTraduccioRepository extends BaseRepository<ArticleTraduccioEntity, ArticleTraduccioPk> {
}