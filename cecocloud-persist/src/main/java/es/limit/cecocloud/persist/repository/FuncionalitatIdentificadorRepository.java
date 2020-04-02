/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.logic.api.module.Modul;
import es.limit.cecocloud.persist.entity.FuncionalitatEntity;
import es.limit.cecocloud.persist.entity.FuncionalitatIdentificadorEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;

/**
 * Repository per a gestionar les entitats de tipus funcionalitat-identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FuncionalitatIdentificadorRepository extends BaseRepository<FuncionalitatIdentificadorEntity, Long> {

	List<FuncionalitatIdentificadorEntity> findByIdentificadorIdOrderByFuncionalitatEmbeddedDescripcio(Long identificadorId);
	List<FuncionalitatIdentificadorEntity> findByFuncionalitatPareNullAndIdentificadorIdOrderByFuncionalitatEmbeddedDescripcio(Long identificadorId);
	List<FuncionalitatIdentificadorEntity> findByFuncionalitatOrderByIdentificador(FuncionalitatEntity funcionalitat);
	List<FuncionalitatIdentificadorEntity> findByFuncionalitatPareAndIdentificadorOrderByIdentificador(FuncionalitatEntity funcionalitat, IdentificadorEntity identificador);

	@Query(
			"select " +
			"    fid.funcionalitat " +
			" from " +
			"    FuncionalitatIdentificadorEntity fid " +
			"where " +
			"    fid.identificador = :identificador " +
			"and (:esNullModul = true or fid.funcionalitat.embedded.modul = :modul) " +
			"order by " +
			"    fid.funcionalitat.embedded.modul asc")
	List<FuncionalitatEntity> findFuncionalitatByIdentificadorAndModulOrderByFuncionalitatModul(
			@Param("identificador") IdentificadorEntity identificador,
			@Param("esNullModul") boolean esNullModul,
			@Param("modul") Modul modul);

}
