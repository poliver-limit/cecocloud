/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.persist.entity.IdentificadorEntity;

/**
 * Repositori per a gestionar les entitats de tipus Identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("IdentificadorRrhhRepository")
public interface IdentificadorRepository extends BaseRepository<IdentificadorEntity, String> {
}