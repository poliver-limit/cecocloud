/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.EmpresaGrupEmpreses.EmpresaGrupEmpresesPk;
import es.limit.cecocloud.fact.persist.entity.EmpresaGrupEmpresesEntity;

/**
 * Repositori per a gestionar les entitats de tipus EmpresaGrupEmpreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factEmpresaGrupEmpresesRepository")
public interface EmpresaGrupEmpresesRepository extends BaseRepository<EmpresaGrupEmpresesEntity, EmpresaGrupEmpresesPk> {
}