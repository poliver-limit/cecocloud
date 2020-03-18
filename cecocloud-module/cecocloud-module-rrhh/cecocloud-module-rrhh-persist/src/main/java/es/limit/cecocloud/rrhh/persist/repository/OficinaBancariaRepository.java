/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.OficinaBancaria.OficinaBancariaPk;
import es.limit.cecocloud.rrhh.persist.entity.OficinaBancariaEntity;

/**
 * Repositori per a gestionar les entitats de OficinaBancaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("rrhhOficinaBancariaRepository")
public interface OficinaBancariaRepository extends BaseRepository<OficinaBancariaEntity, OficinaBancariaPk> {

}
