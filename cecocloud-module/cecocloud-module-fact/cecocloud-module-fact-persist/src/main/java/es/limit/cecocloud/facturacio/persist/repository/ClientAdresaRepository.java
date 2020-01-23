package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.ClientAdresa.ClientAdresaPk;
import es.limit.cecocloud.facturacio.persist.entity.ClientAdresaEntity;

/**
 * Repositori per a gestionar les entitats de ClientAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

public interface ClientAdresaRepository extends BaseRepository<ClientAdresaEntity, ClientAdresaPk> {

}
