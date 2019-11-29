/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.Empresa.EmpresaPk;
import es.limit.cecocloud.facturacio.persist.entity.EmpresaEntity;

/**
 * Repositori per a gestionar les entitats de tipus Empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface EmpresaRepository extends BaseRepository<EmpresaEntity, EmpresaPk> {
}