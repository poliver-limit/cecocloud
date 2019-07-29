/**
 * 
 */
package es.limit.cecocloud.persist.repository;

import java.util.List;

import es.limit.cecocloud.persist.entity.CompanyiaEntity;
import es.limit.cecocloud.persist.entity.EmpresaEntity;
/**
 * Repository per a gestionar les entitats de tipus empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface EmpresaRepository extends BaseRepository<EmpresaEntity, Long> {

	List<EmpresaEntity> findByParent1(CompanyiaEntity companyia);

}
