/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.ArticleEntity;

/**
 * Repositori per a gestionar les entitats de tipus Article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomArticleRepository")
public interface ArticleRepository extends BaseRepository<ArticleEntity, WithIdentificadorAndCodiPk<String>> {
}