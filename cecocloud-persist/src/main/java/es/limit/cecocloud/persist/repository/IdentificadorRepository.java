/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;

/**
 * Mètodes necessaris per a gestionar una entitat de base
 * de dades del tipus identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface IdentificadorRepository extends BaseRepository<IdentificadorEntity, String> {

//	Optional<IdentificadorEntity> findByCodi(String codi);

	List<IdentificadorEntity> findByCompanyia(CompanyiaEntity companyia);

	/*@Query("from "
			+ " IdentificadorEntity i "
			+ " where "
			+ " i.companyia.embedded.codi = :companyiaCodi")
	Page<IdentificadorEntity> findByFiltre(@Param("companyiaCodi") String companyiaCodi, Pageable pageable);*/

}
