/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.logic.api.dto.FuncionalitatRecursInfo;
import es.limit.cecocloud.logic.api.module.Modul;
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

	FuncionalitatIdentificadorPerfilEntity findByPerfilAndFuncionalitatIdentificadorAndEmbeddedPermis(
			PerfilEntity perfil,
			FuncionalitatIdentificadorEntity funcionalitat,
			String permis);

	List<FuncionalitatIdentificadorPerfilEntity> findByPerfilIdAndFuncionalitatIdentificadorId(
			Long perfilId,
			Long funcionalitatId);

	List<FuncionalitatIdentificadorPerfilEntity> findByPerfilIdInOrderByFuncionalitatIdentificadorFuncionalitatEmbeddedDescripcio(
			List<Long> perfilId);

	List<FuncionalitatIdentificadorPerfilEntity> findByFuncionalitatIdentificadorFuncionalitatOrderByFuncionalitatIdentificadorIdentificador(
			FuncionalitatEntity funcionalitat);

	List<FuncionalitatIdentificadorPerfilEntity> findByFuncionalitatIdentificadorOrderByPerfil(
			FuncionalitatIdentificadorEntity funcionalitatIdentificador);

	List<FuncionalitatIdentificadorPerfilEntity> findByFuncionalitatIdentificadorFuncionalitat(
			FuncionalitatEntity funcionalitat);

	@Query(	"select distinct f " +
			" from " +
			"    FuncionalitatIdentificadorPerfilEntity fip " +
			"    left outer join fip.funcionalitatIdentificador as fi " +
			"    left outer join fi.funcionalitat as f " +
			"where " +
			"	 fip.perfil in :perfils " +
			"and UPPER(fip.embedded.permis) = 'READ' " + // or UPPER(fip.embedded.permis) = 'ADMINISTRATION') " +
			"and f.embedded.modul = :modul ")
	List<FuncionalitatEntity> findAllowedFuncionalitatsByPerfilsAndModul(List<PerfilEntity> perfils, Modul modul);

	@Query(	"select new es.limit.cecocloud.logic.api.dto.FuncionalitatRecursInfo(" + 
			"		fr.recurs.embedded.className," +
			" 		fr.embedded.principal, " +
			" 		fip.embedded.permis) " +
			//"select case fr.embedded.principal when fr.embedded.principal then fip.embedded.permis else 'READ' end " +
			" from " +
			"    FuncionalitatRecursEntity fr, " +
			"    FuncionalitatIdentificadorEntity fi, " +
			"    FuncionalitatIdentificadorPerfilEntity fip " +
			"where " +
			"	 fr.recurs = :recurs " +
			"and fi.funcionalitat = fr.funcionalitat " +
			"and fip.funcionalitatIdentificador = fi " +
			"and fip.perfil.id = :perfilId")	
	List<FuncionalitatRecursInfo> findPermisosByRecursAndPerfilId(RecursEntity recurs, Long perfilId);

}
