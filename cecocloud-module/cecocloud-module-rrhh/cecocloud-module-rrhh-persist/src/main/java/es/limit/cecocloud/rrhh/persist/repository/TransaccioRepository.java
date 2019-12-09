/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.Transaccio.TransaccioPk;
import es.limit.cecocloud.rrhh.persist.entity.TransaccioEntity;

/**
 * Repositori per a gestionar les entitats de tipus Transaccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TransaccioRepository extends BaseRepository<TransaccioEntity, TransaccioPk> {
}