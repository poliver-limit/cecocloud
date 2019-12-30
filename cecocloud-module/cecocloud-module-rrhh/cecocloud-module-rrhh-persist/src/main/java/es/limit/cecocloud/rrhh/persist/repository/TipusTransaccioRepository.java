/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.persist.entity.TipusTransaccioEntity;

/**
 * Repositori per a gestionar les entitats de tipus TipusTransaccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TipusTransaccioRepository extends BaseRepository<TipusTransaccioEntity, WithIdentificadorAndCodiPk<Integer>> {
}