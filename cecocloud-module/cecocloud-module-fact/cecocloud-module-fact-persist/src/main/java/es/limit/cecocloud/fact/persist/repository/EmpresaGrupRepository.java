/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.EmpresaGrup.EmpresaGrupPk;
import es.limit.cecocloud.fact.persist.entity.EmpresaGrupEntity;

/**
 * Repositori per a gestionar les entitats de tipus EmpresaGrup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factEmpresaGrupRepository")
public interface EmpresaGrupRepository extends BaseRepository<EmpresaGrupEntity, EmpresaGrupPk> {
}