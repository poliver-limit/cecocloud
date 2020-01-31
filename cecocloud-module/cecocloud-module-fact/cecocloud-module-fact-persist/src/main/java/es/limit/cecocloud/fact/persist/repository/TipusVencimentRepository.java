/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.TipusVencimentEntity;

/**
 * Repositori per a gestionar les entitats de tipus tipus de venciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TipusVencimentRepository extends BaseRepository<TipusVencimentEntity, WithIdentificadorAndCodiPk<String>> {
}