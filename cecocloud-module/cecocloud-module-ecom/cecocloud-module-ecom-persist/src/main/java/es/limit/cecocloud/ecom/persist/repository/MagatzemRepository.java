/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.MagatzemEntity;

/**
 * Repositori per a gestionar les entitats de tipus Magatzem
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomMagatzemRepository")
public interface MagatzemRepository extends BaseRepository<MagatzemEntity, WithIdentificadorAndCodiPk<String>> {
}