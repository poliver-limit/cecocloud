/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.ConfiguracioImpressosEntity;

/**
 * Repository to manage entities from type ConfiguracioImpressos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ConfiguracioImpressosRepository extends BaseRepository<ConfiguracioImpressosEntity, WithIdentificadorAndCodiPk<String>> {
}