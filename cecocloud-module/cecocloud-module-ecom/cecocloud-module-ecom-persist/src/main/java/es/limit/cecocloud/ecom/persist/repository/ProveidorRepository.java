/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.ProveidorEntity;

/**
 * Repositori per a gestionar les entitats de tipus Proveidor
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomProveidorRepository")
public interface ProveidorRepository extends BaseRepository<ProveidorEntity, WithIdentificadorAndCodiPk<String>> {
}