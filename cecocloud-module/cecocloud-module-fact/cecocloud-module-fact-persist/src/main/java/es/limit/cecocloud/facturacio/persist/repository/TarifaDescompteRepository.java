/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.TarifaDescompte.TarifaDescomptePk;
import es.limit.cecocloud.facturacio.persist.entity.TarifaDescompteEntity;

/**
 * Repositori per a gestionar les entitats de tipus TarifaDescompte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TarifaDescompteRepository extends BaseRepository<TarifaDescompteEntity, TarifaDescomptePk> {
}