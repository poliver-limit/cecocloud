/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.persist.entity.HorariEntity;

/**
 * Repositori per a gestionar les entitats de tipus Horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("rrhhHorariRepository")
public interface HorariRepository extends BaseRepository<HorariEntity, WithIdentificadorAndCodiPk<String>> {
}