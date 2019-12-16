/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.EmpresaRrhh.EmpresaRrhhPk;
import es.limit.cecocloud.rrhh.persist.entity.EmpresaRrhhEntity;

/**
 * Repositori per a gestionar les entitats de tipus Empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("EmpresaRrhhRepository")
public interface EmpresaRrhhRepository extends BaseRepository<EmpresaRrhhEntity, EmpresaRrhhPk> {
}