/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;
import java.util.Optional;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.persist.entity.CompanyiaEntity;
import es.limit.cecocloud.persist.entity.EmpresaEntity;

/**
 * Repository per a gestionar les entitats de tipus empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface EmpresaRepository extends BaseRepository<EmpresaEntity, Long> {

	List<EmpresaEntity> findByIdentificadorCompanyia(CompanyiaEntity companyia);

	Optional<EmpresaEntity> findByIdentificadorCompanyiaAndIdentificadorEmbeddedCodiAndEmbeddedCodi(
			CompanyiaEntity companyia,
			String identificadorCodi,
			String codi);

}
