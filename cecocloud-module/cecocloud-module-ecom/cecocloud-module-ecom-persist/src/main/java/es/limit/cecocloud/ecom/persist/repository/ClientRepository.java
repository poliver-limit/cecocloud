/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.ClientEntity;

/**
 * Repositori per a gestionar les entitats de tipus client.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomClientRepository")
public interface ClientRepository extends BaseRepository<ClientEntity, WithIdentificadorAndCodiPk<String>> {
}



