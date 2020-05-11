/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.ecom.persist.entity.IdiomaEntity;

/**
 * Repositori per a gestionar les entitats de tipus Idioma
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomIdiomaRepository")
public interface IdiomaRepository extends BaseRepository<IdiomaEntity, WithIdentificadorAndCodiPk<String>> {
}