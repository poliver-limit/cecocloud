/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.PaisEntity;

/**
 * Repositori per a gestionar les entitats de tipus pais.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomPaisRepository")
public interface PaisRepository extends BaseRepository<PaisEntity, WithIdentificadorAndCodiPk<String>> {
}