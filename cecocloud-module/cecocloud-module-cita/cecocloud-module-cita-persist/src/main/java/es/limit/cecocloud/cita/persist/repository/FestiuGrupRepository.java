/**
 * 
 */
package es.limit.cecocloud.cita.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.cita.persist.entity.FestiuGrupEntity;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;

/**
 * Repositori per a gestionar les entitats de tipus grup de festius.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FestiuGrupRepository extends BaseRepository<FestiuGrupEntity, WithIdentificadorAndCodiPk<String>> {
}