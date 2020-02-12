/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//github.com/programari-limit/cecocloud

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.RecursEntity;

/**
 * Repository per a gestionar les entitats de tipus recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface RecursRepository extends BaseRepository<RecursEntity, Long> {

	@Query(	"select distinct fr.recurs " +
			" from " +
//			"    FuncionalitatEntity f, " +
			"    FuncionalitatRecursEntity fr, " +
			"    FuncionalitatIdentificadorEntity fi, " +
			"    FuncionalitatIdentificadorPerfilEntity fip " +
			"where " +
//			"    fr.funcionalitat =  f " +
//			"and f = fi.funcionalitat " +
//			"and fr.funcionalitat = f " +
			"fi.funcionalitat = fr.funcionalitat " +
			"and fip.funcionalitatIdentificador = fi " +
			"and fip.perfil.id = :perfilId")	
	List<RecursEntity> findByPerfilId(@Param("perfilId") Long perfilId);

	Optional<RecursEntity> findByEmbeddedClassName(String className);

	List<RecursEntity> findByEmbeddedClassNameStartingWith(String classNamePrefix);

}
