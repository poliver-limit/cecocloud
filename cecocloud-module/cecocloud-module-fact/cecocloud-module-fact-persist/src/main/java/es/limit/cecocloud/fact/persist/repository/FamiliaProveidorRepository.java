/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.FamiliaProveidorEntity;

/**
 * Repositori per a gestionar les entitats de tipus familia proveidor.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FamiliaProveidorRepository extends BaseRepository<FamiliaProveidorEntity, WithIdentificadorAndCodiPk<String>> {
}