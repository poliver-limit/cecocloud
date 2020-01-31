/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.ClientEntity;

/**
 * Repositori per a gestionar les entitats de tipus client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ClientRepository extends BaseRepository<ClientEntity, WithIdentificadorAndCodiPk<String>> {
}


