/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.limit.cecocloud.persist.entity.EmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariEmpresaEntity;
import es.limit.cecocloud.persist.entity.UsuariEntity;
/**
 * Repository per a gestionar les entitats de tipus relació usuari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface UsuariEmpresaRepository extends BaseRepository<UsuariEmpresaEntity, Long> {

	@Query(	"from" +
			"    UsuariEmpresaEntity ue " +
			"where " +
			"    ue.parent1 = :usuari " +
			"and ue.parent2.embedded.activa = :activa")
	List<UsuariEmpresaEntity> findByParent1AndEmpresaActiva(
			@Param("usuari") UsuariEntity usuari,
			@Param("activa") boolean activa);

	@Query(	"from" +
			"    UsuariEmpresaEntity ue " +
			"where " +
			"    ue.parent2 = :empresa " +
			"and ue.embedded.dataFi is null")
	List<UsuariEmpresaEntity> findByParent2AndDataFiNull(
			@Param("empresa") EmpresaEntity empresa);

	List<UsuariEmpresaEntity> findByParent1AndParent2(UsuariEntity usuari, EmpresaEntity empresa);

}
