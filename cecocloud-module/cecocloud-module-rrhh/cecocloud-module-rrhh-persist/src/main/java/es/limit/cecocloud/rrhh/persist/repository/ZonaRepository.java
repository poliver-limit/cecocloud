/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.AbstractIdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.rrhh.persist.entity.ZonaEntity;

/**
 * Repositori per a gestionar les entitats de tipus Zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ZonaRrhhRepository")
public interface ZonaRepository extends BaseRepository<ZonaEntity, WithIdentificadorAndCodiPk<String>> {
}