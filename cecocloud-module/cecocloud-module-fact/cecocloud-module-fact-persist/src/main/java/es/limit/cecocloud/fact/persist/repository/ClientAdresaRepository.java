/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.ClientAdresa.ClientAdresaPk;
import es.limit.cecocloud.fact.persist.entity.ClientAdresaEntity;

/**
 * Repositori per a gestionar les entitats de ClientAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

public interface ClientAdresaRepository extends BaseRepository<ClientAdresaEntity, ClientAdresaPk> {

}
