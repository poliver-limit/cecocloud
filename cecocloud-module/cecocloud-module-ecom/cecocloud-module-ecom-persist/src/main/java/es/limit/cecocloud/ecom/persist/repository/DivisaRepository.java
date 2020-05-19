/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.DivisaEntity;

/**
 * Repositori per a gestionar les entitats de tipus divisa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomDivisaRepository")
public interface DivisaRepository extends BaseRepository<DivisaEntity, WithIdentificadorAndCodiPk<String>> {
}