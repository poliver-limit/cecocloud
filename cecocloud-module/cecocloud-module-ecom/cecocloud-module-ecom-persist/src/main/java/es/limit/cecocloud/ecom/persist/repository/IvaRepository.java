/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.IvaEntity;

/**
 * Repositori per a gestionar les entitats de tipus iva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomIvaRepository")
public interface IvaRepository extends BaseRepository<IvaEntity, WithIdentificadorAndCodiPk<String>> {
}