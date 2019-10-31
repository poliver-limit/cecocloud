/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.UsuariEmpresaEntity;

/**
 * Mètodes necessaris per a gestionar una entitat de base
 * de dades de tipus usuari-empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface UsuariEmpresaRepository extends BaseRepository<UsuariEmpresaEntity, Long> {
	
	@Query("from "
			+ " UsuariEmpresaEntity uem "
			+ " where "
			+ " lower(uem.empresa.identificador.id) = lower(:identificadorCodi)"
			+ " and lower(uem.usuari.codi) = lower(:usuariCodi)")
	Page<UsuariEmpresaEntity> findByFilter(
			@Param("usuariCodi") String usuariCodi,
			@Param("identificadorCodi") String identificadorCodi,
			Pageable pageable);
	
	@Query("from "
			+ " UsuariEmpresaEntity uem "
			+ " where "
			+ " lower(uem.empresa.identificador.id) = lower(:identificadorCodi)"
			+ " and lower(uem.usuari.codi) = lower(:usuariCodi)")
	List<UsuariEmpresaEntity> findByUsuariCodiAndIdentificadorCodi(
			@Param("usuariCodi") String usuariCodi,
			@Param("identificadorCodi") String identificadorCodi);
	
	UsuariEmpresaEntity getByUsuariCodiAndEmpresaCodi(
			String usuariCodi,
			Long empresaCodi);
}
