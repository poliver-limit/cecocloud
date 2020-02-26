/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.RegistreComercial.RegistreComercialPk;
import es.limit.cecocloud.fact.persist.entity.RegistreComercialEntity;

/**
 * Repositori per a gestionar les entitats de tipus RegistreComercial.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface RegistreComercialRepository extends BaseRepository<RegistreComercialEntity, RegistreComercialPk> {
}