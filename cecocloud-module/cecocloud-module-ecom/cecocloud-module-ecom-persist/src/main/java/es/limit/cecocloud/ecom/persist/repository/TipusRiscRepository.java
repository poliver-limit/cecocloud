/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.TipusRiscEntity;

/**
 * Repositori per a gestionar les entitats de tipus TipusRisc
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomTipusRiscRepository")
public interface TipusRiscRepository extends BaseRepository<TipusRiscEntity, WithIdentificadorAndCodiPk<String>> {
}