/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;
import es.limit.cecocloud.rrhh.persist.entity.TipusTransaccioEntity;

/**
 * Repositori per a gestionar les entitats de tipus TipusTransaccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
//public interface TipusTransaccioRepository extends BaseRepository<TipusTransaccioEntity, AmbIdentificadorICodiPk<Integer>> {
public interface TipusTransaccioRepository extends BaseRepository<TipusTransaccioEntity, AmbIdentificadorICodiPk<String>> {
}