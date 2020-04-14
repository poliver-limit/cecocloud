/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.Pressupost.PressupostPk;
import es.limit.cecocloud.fact.persist.entity.PressupostEntity;

/**
 * Repositori per a gestionar les entitats de tipus Pressupost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface PressupostRepository extends BaseRepository<PressupostEntity, PressupostPk> {
}