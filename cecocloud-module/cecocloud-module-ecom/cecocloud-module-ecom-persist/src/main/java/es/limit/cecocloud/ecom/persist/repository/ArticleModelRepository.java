/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.ArticleModelEntity;

/**
 * Repositori per a gestionar les entitats de tipus ArticleModel.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomArticleModelRepository")
public interface ArticleModelRepository extends BaseRepository<ArticleModelEntity, WithIdentificadorAndCodiPk<String>> {
}