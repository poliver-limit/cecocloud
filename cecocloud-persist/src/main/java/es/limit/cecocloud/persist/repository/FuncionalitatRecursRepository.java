/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.logic.api.dto.FuncionalitatRecursInfo;
import es.limit.cecocloud.persist.entity.FuncionalitatEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatRecursEntity;

/**
 * Repository per a gestionar les entitats de tipus funcionalitat-recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FuncionalitatRecursRepository extends BaseRepository<FuncionalitatRecursEntity, Long> {

	List<FuncionalitatRecursEntity> findByFuncionalitat(FuncionalitatEntity funcionalitat);
	List<FuncionalitatRecursEntity> findByFuncionalitatInAndEmbeddedResourceClassName(List<FuncionalitatEntity> funcionalitats, String resourceName);
	
	@Query(	"select fr.embedded.resourceClassName," +
			" 		fr.embedded.principal, " +
			" 		fp.embedded.permis, " +
			" from " +
			"    FuncionalitatEntity f " +
			"    FuncionalitatRecursEntity fr " +
			"    FuncionalitatPerfilEntity fp " +
			"where " +
			"    f in :funcionalitats " +
			"and fr.funcionalitat = f " +
			"and fp.funcionalitat = f " +
			"and fr.embedded.resourceClassName = :resourceName")
	List<FuncionalitatRecursInfo> findPermisosByFuncionalitatsAndRecurs(
			@Param("funcionalitats") List<FuncionalitatEntity> funcionalitats, 
			@Param("resourceName") String resourceName);
	
}
