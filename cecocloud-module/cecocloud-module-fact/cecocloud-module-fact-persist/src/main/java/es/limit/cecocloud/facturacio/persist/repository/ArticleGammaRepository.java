/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.persist.entity.ArticleGammaEntity;

/**
 * Repositori per a gestionar les entitats de tipus ArticleGamma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ArticleGammaRepository extends BaseRepository<ArticleGammaEntity, AmbIdentificadorICodiPk<String>> {
}