/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.ZonaEntity;

/**
 * Repositori per a gestionar les entitats de tipus zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factZonaRepository")
public interface ZonaRepository extends BaseRepository<ZonaEntity, WithIdentificadorAndCodiPk<String>> {
}