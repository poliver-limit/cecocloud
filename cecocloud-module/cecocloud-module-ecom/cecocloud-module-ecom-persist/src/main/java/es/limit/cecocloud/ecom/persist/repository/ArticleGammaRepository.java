/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.ArticleGammaEntity;

/**
 * Repositori per a gestionar les entitats de tipus ArticleGamma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomArticleGammaRepository")
public interface ArticleGammaRepository extends BaseRepository<ArticleGammaEntity, WithIdentificadorAndCodiPk<String>> {
}