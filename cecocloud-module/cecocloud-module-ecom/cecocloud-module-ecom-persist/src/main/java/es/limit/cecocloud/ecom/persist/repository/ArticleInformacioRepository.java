/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.persist.entity.ArticleInformacioEntity;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleInformacio.ArticleInformacioPk;

/**
 * Repositori per a gestionar les entitats de tipus ArticleInformacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomArticleInformacioRepository")
public interface ArticleInformacioRepository extends BaseRepository<ArticleInformacioEntity, ArticleInformacioPk> {
}