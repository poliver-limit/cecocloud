/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.EmpresaFact.EmpresaFactPk;
import es.limit.cecocloud.facturacio.persist.entity.EmpresaFactEntity;

/**
 * Repositori per a gestionar les entitats de tipus Empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factEmpresaRepository")
public interface EmpresaFactRepository extends BaseRepository<EmpresaFactEntity, EmpresaFactPk> {
}