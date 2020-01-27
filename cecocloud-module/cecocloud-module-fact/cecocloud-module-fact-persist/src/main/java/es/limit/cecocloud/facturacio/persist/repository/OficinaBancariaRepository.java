/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.OficinaBancaria.OficinaBancariaPk;
import es.limit.cecocloud.facturacio.persist.entity.OficinaBancariaEntity;

/**
 * Repositori per a gestionar les entitats de OficinaBancaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

public interface OficinaBancariaRepository extends BaseRepository<OficinaBancariaEntity, OficinaBancariaPk> {

}
