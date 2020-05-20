/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.FamiliaClientEntity;

/**
 * Repositori per a gestionar les entitats de tipus FamiliaClient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomFamiliaClientRepository")
public interface FamiliaClientRepository extends BaseRepository<FamiliaClientEntity, WithIdentificadorAndCodiPk<String>> {
}