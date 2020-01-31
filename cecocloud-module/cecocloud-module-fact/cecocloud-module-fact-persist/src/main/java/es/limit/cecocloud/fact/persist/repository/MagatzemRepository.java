/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.MagatzemEntity;

/**
 * Repositori per a gestionar les entitats de tipus Magatzem.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface MagatzemRepository extends BaseRepository<MagatzemEntity, WithIdentificadorAndCodiPk<String>> {
}