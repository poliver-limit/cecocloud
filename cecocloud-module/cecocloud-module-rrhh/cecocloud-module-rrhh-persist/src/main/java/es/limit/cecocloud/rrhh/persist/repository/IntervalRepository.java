/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.persist.entity.IntervalEntity;

/**
 * Repositori per a gestionar les entitats de tipus Interval.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IntervalRepository extends BaseRepository<IntervalEntity, WithIdentificadorAndCodiPk<String>> {
}