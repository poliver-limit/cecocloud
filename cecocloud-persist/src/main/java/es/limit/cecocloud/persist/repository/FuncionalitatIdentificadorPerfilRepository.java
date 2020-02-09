/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.FuncionalitatEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorPerfilEntity;
import es.limit.cecocloud.persist.entity.PerfilEntity;
import es.limit.cecocloud.persist.entity.RecursEntity;

/**
 * Repository per a gestionar les entitats de tipus funcionalitat-perfil.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FuncionalitatIdentificadorPerfilRepository extends BaseRepository<FuncionalitatIdentificadorPerfilEntity, Long> {

	FuncionalitatIdentificadorPerfilEntity findByPerfilAndFuncionalitatIdentificadorAndEmbeddedPermis(PerfilEntity perfil, FuncionalitatIdentificadorEntity funcionalitat, String permis);
	List<FuncionalitatIdentificadorPerfilEntity> findByPerfilIdAndFuncionalitatIdentificadorId(Long perfilId, Long funcionalitatId);
	List<FuncionalitatIdentificadorPerfilEntity> findByPerfilIdOrderByFuncionalitatIdentificadorFuncionalitatEmbeddedDescripcio(Long perfilId);
	List<FuncionalitatIdentificadorPerfilEntity> findByPerfilIdInOrderByFuncionalitatIdentificadorFuncionalitatEmbeddedDescripcio(List<Long> perfilId);
	List<FuncionalitatIdentificadorPerfilEntity> findByFuncionalitatIdentificadorFuncionalitatOrderByFuncionalitatIdentificadorIdentificador(FuncionalitatEntity funcionalitat);
	List<FuncionalitatIdentificadorPerfilEntity> findByFuncionalitatIdentificadorOrderByPerfil(FuncionalitatIdentificadorEntity funcionalitatIdentificador);
	
	@Query(	"select case fip.embedded.permis when fr.embedded.principal then fip.embedded.permis else 'READ' end " +
			" from " +
			"    FuncionalitatRecursEntity fr, " +
			"    FuncionalitatIdentificadorEntity fi, " +
			"    FuncionalitatIdentificadorPerfilEntity fip " +
			"where " +
			"	 fr.recurs = :recurs " +
			"and fr.funcionalitat = fr.funcionalitat " +
			"and fi.funcionalitat = fr.funcionalitat " +
			"and fip.funcionalitatIdentificador = fi " +
			"and fip.perfil = :perfil")	
	Set<String> findPermisosByRecursAndPerfil(RecursEntity recurs, PerfilEntity perfil);
	
}
