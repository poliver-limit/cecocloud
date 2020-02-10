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
import es.limit.cecocloud.persist.entity.PerfilEntity;
import es.limit.cecocloud.persist.entity.RecursEntity;

/**
 * Repository per a gestionar les entitats de tipus funcionalitat-recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FuncionalitatRecursRepository extends BaseRepository<FuncionalitatRecursEntity, Long> {

	List<FuncionalitatRecursEntity> findByFuncionalitat(FuncionalitatEntity funcionalitat);
//	FuncionalitatRecursEntity findByFuncionalitatInAndRecursEmbeddedClassName(
//			List<FuncionalitatEntity> funcionalitats,
//			String className);
	FuncionalitatRecursEntity findByFuncionalitatAndRecurs(
			FuncionalitatEntity funcionalitat,
			RecursEntity recurs);
	
	@Query(	"select fr " +
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
			"and fip.perfil = :perfil")	
	List<FuncionalitatRecursEntity> findByPerfil(PerfilEntity perfil);
	
	@Query(	"select new es.limit.cecocloud.logic.api.dto.FuncionalitatRecursInfo(" + 
			"		fr.recurs.embedded.className," +
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
			"and fr.recurs.embedded.className = :recursClassName")
	List<FuncionalitatRecursInfo> findPermisosByFuncionalitatsIdentificadorAndRecurs(
			@Param("funcionalitatsIdentificador") List<FuncionalitatIdentificadorEntity> funcionalitatsIdentificador, 
			@Param("recursClassName") String recursClassName);
	
}
