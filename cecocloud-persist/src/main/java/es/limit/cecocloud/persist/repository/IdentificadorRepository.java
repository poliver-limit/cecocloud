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
import es.limit.cecocloud.persist.entity.IdentificadorEntity;

/**
 * Mètodes necessaris per a gestionar una entitat de base
 * de dades del tipus identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface IdentificadorRepository extends BaseRepository<IdentificadorEntity, String> {
	List<IdentificadorEntity> findByCompanyiaEmbeddedCodi(String companyiaCodi);
	
	@Query("from "
			+ " IdentificadorEntity i "
			+ " where "
			+ " i.companyia.embedded.codi = :companyiaCodi")
	Page<IdentificadorEntity> findByFiltre(@Param("companyiaCodi") String companyiaCodi, Pageable pageable);
}
