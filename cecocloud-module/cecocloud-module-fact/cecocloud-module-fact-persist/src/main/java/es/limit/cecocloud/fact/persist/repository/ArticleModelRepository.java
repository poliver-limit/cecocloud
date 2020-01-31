/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.ArticleModelEntity;

/**
 * Repositori per a gestionar les entitats de tipus ArticleModel.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ArticleModelRepository extends BaseRepository<ArticleModelEntity, WithIdentificadorAndCodiPk<String>> {
}