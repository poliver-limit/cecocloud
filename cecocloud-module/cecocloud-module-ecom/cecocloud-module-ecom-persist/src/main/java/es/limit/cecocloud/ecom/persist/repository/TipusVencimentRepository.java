/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.TipusVencimentEntity;

/**
 * Repositori per a gestionar les entitats de tipus TipusVenciment
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomTipusVencimentRepository")
public interface TipusVencimentRepository extends BaseRepository<TipusVencimentEntity, WithIdentificadorAndCodiPk<String>> {
}