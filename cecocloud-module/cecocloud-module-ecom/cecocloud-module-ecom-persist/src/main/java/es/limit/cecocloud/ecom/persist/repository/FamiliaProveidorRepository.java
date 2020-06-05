/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.FamiliaProveidorEntity;

/**
 * Repositori per a gestionar les entitats de tipus FamiliaProveidor
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomFamiliaProveidorRepository")
public interface FamiliaProveidorRepository extends BaseRepository<FamiliaProveidorEntity, WithIdentificadorAndCodiPk<String>> {
}