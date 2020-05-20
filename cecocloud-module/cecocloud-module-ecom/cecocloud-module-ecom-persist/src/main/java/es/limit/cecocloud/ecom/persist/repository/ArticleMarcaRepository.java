/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.ArticleMarcaEntity;

/**
 * Repositori per a gestionar les entitats de tipus article-marca.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomArticleMarcaRepository")
public interface ArticleMarcaRepository extends BaseRepository<ArticleMarcaEntity, WithIdentificadorAndCodiPk<String>> {
}