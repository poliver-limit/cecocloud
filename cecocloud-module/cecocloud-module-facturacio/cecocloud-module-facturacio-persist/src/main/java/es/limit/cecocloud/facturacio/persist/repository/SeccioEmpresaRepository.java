/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.SeccioEmpresa.SeccioEmpresaPk;
import es.limit.cecocloud.facturacio.persist.entity.SeccioEmpresaEntity;

/**
 * Repositori per a gestionar les entitats de tipus SeccioEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SeccioEmpresaRepository extends BaseRepository<SeccioEmpresaEntity, SeccioEmpresaPk> {
}