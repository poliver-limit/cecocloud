/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.FuncionalitatEntity;
import es.limit.cecocloud.persist.entity.PerfilEntity;

/**
 * Repository per a gestionar les entitats de tipus funcionalitat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface FuncionalitatRepository extends BaseRepository<FuncionalitatEntity, Long> {

	@Query(
			"select " +
			"    fip.funcionalitatIdentificador.funcionalitat " +
			" from " +
			"    FuncionalitatIdentificadorPerfilEntity fip " +
			"where " +
			"    fip.perfil in (:perfils)")
	List<FuncionalitatEntity> findByPerfilIn(
			@Param("perfils") List<PerfilEntity> perfils);

}
