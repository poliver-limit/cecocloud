/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;
import es.limit.cecocloud.persist.entity.EmpresaEntity;

/**
 * Repository per a gestionar les entitats de tipus empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository
public interface EmpresaRepository extends BaseRepository<EmpresaEntity, Long> {

	List<EmpresaEntity> findByIdentificadorCompanyia(CompanyiaEntity companyia);

	Optional<EmpresaEntity> findByIdentificadorCompanyiaAndIdentificadorIdAndEmbeddedCodi(
			CompanyiaEntity companyia,
			String identificadorCodi,
			String codi);

}
