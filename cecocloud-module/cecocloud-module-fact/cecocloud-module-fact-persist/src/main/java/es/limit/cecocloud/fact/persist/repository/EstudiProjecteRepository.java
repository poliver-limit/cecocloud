/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.EstudiProjecte.EstudiProjectePk;
import es.limit.cecocloud.fact.persist.entity.EstudiProjecteEntity;

/**
 * Repositori per a gestionar les entitats de tipus EstudiProjecte.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factEstudiProjecteRepository")
public interface EstudiProjecteRepository extends BaseRepository<EstudiProjecteEntity, EstudiProjectePk> {
}