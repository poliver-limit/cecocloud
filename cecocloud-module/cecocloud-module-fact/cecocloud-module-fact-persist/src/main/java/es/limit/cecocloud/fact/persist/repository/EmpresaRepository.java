/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.EmpresaEntity;

/**
 * Repositori per a gestionar les entitats de tipus Empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factEmpresaRepository")
public interface EmpresaRepository extends BaseRepository<EmpresaEntity, WithIdentificadorAndCodiPk<String>> {
}