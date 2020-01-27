/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.facturacio.persist.entity.ClientEntity;

/**
 * Repositori per a gestionar les entitats de tipus client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ClientRepository extends BaseRepository<ClientEntity, WithIdentificadorAndCodiPk<String>> {
}


