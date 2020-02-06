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
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatRecursEntity;

/**
 * Repository per a gestionar les entitats de tipus funcionalitat-recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FuncionalitatRecursRepository extends BaseRepository<FuncionalitatRecursEntity, Long> {

	List<FuncionalitatRecursEntity> findByFuncionalitat(FuncionalitatEntity funcionalitat);
	List<FuncionalitatRecursEntity> findByFuncionalitatInAndEmbeddedResourceClassName(List<FuncionalitatEntity> funcionalitats, String resourceName);
	
	@Query(	"select new es.limit.cecocloud.logic.api.dto.FuncionalitatRecursInfo(" + 
			"		fr.embedded.resourceClassName," +
			" 		fr.embedded.principal, " +
			" 		fip.embedded.permis) " +
			" from " +
//			"    FuncionalitatEntity f, " +
			"    FuncionalitatRecursEntity fr, " +
			"    FuncionalitatIdentificadorEntity fi, " +
			"    FuncionalitatIdentificadorPerfilEntity fip " +
			"where " +
			"    fi in :funcionalitatsIdentificador " +
//			"and f = fi.funcionalitat " +
//			"and fr.funcionalitat = f " +
			"and fr.funcionalitat = fi.funcionalitat " +
			"and fip.funcionalitatIdentificador = fi " +
			"and fr.embedded.resourceClassName = :resourceName")
	List<FuncionalitatRecursInfo> findPermisosByFuncionalitatsIdentificadorAndRecurs(
			@Param("funcionalitatsIdentificador") List<FuncionalitatIdentificadorEntity> funcionalitatsIdentificador, 
			@Param("resourceName") String resourceName);
	
}
