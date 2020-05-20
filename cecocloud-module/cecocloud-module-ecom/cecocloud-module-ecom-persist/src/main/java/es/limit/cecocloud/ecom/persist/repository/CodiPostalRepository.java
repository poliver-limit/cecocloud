/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.CodiPostalEntity;

/**
 * Repositori per a gestionar les entitats de tipus CodiPostal.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomCodiPostalRepository")
public interface CodiPostalRepository extends BaseRepository<CodiPostalEntity, WithIdentificadorAndCodiPk<String>> {
}