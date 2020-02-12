/**
 * 
 */
package es.limit.cecocloud.lici.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.lici.persist.entity.LicitacioEntity;

/**
 * Repository per a gestionar l'entitat de licitació.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface LicitacioRepository extends BaseRepository<LicitacioEntity, Long> {

}
