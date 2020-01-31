/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.SeccioEmpresa.SeccioEmpresaPk;
import es.limit.cecocloud.fact.persist.entity.SeccioEmpresaEntity;

/**
 * Repositori per a gestionar les entitats de tipus SeccioEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SeccioEmpresaRepository extends BaseRepository<SeccioEmpresaEntity, SeccioEmpresaPk> {
}