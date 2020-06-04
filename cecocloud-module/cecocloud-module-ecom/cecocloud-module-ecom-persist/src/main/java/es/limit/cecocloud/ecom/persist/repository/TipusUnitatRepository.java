/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.TipusUnitatEntity;

/**
 * Repositori per a gestionar les entitats de tipus TipusUnitat
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomTipusUnitatRepository")
public interface TipusUnitatRepository extends BaseRepository<TipusUnitatEntity, WithIdentificadorAndCodiPk<String>> {
}