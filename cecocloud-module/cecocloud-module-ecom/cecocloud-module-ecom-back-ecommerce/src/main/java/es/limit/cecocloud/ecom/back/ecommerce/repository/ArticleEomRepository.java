/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.back.ecommerce.persist.entity.ArticleEcomEntity;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;

/**
 * Repositori per a gestionar les entitats de tipus Article.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomBackArticleRepository")
public interface ArticleEomRepository extends BaseRepository<ArticleEcomEntity, WithIdentificadorAndCodiPk<String>> {
}