/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.RegimIvaEntity;

/**
 * Repositori per a gestionar les entitats de tipus RegimIva
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomRegimIvaRepository")
public interface RegimIvaRepository extends BaseRepository<RegimIvaEntity, WithIdentificadorAndCodiPk<String>> {
}