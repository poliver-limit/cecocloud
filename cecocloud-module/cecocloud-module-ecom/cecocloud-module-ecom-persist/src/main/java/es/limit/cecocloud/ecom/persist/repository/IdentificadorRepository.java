/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.persist.entity.IdentificadorEntity;

/**
 * Repositori per a gestionar les entitats de tipus identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomIdentificadorRepository")
public interface IdentificadorRepository extends BaseRepository<IdentificadorEntity, String> {
}