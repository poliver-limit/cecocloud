/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.persist.entity.ComptadorEntity;
import es.limit.cecocloud.logic.api.dto.Comptador.ComptadorPk;

/**
 * Repositori per a gestionar les entitats de tipus comptador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ComptadorRepository extends BaseRepository<ComptadorEntity, ComptadorPk> {
}