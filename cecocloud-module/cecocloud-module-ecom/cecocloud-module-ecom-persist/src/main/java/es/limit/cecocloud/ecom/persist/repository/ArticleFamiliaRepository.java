/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.ArticleFamiliaEntity;

/**
 * Repositori per a gestionar les entitats de tipus ArticleFamilia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomArticleFamiliaRepository")
public interface ArticleFamiliaRepository extends BaseRepository<ArticleFamiliaEntity, WithIdentificadorAndCodiPk<String>> {
}