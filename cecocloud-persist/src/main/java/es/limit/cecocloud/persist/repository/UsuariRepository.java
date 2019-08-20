/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.Optional;

import es.limit.cecocloud.persist.entity.UsuariEntity;

/**
 * Repository per a gestionar les entitats de tipus usuari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface UsuariRepository extends BaseRepository<UsuariEntity, Long> {

	/*@Query(	"from" +
			"    UsuariEntity u " +
			"where " +
			"    u.embedded.codi = :codi")*/
	Optional<UsuariEntity> findByEmbeddedCodi(/*@Param("codi") */String codi);

	/*@Query(	"from" +
			"    UsuariEntity u " +
			"where " +
			"    u.embedded.email = :email")*/
	Optional<UsuariEntity> findByEmbeddedEmail(/*@Param("email") */String email);

}
