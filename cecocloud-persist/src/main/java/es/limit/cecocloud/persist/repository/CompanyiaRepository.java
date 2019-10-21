/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;

/**
 * Repository per a gestionar les entitats de tipus companyia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface CompanyiaRepository extends BaseRepository<CompanyiaEntity, Long> {

	@Query(	"from" +
			"    CompanyiaEntity c " +
			"where " +
			"    c.embedded.codi = :codi")
	Optional<CompanyiaEntity> findByEmbeddedCodis(@Param("codi") String codi);

}
