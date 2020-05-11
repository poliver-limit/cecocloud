/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.PaisNifEntity;

/**
 * Repositori per a gestionar les entitats de tipus PaisNif.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomPaisNifRepository")
public interface PaisNifRepository extends BaseRepository<PaisNifEntity, WithIdentificadorAndCodiPk<String>> {
}