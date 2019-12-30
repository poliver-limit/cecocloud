/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.facturacio.persist.entity.IdiomaEntity;

/**
 * Repositori per a gestionar les entitats de tipus idioma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface IdiomaRepository extends BaseRepository<IdiomaEntity, WithIdentificadorAndCodiPk<String>> {
}