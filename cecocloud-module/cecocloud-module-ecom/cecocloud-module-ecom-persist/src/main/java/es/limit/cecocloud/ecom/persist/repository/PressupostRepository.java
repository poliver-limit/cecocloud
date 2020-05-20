/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.Pressupost.PressupostPk;
import es.limit.cecocloud.ecom.persist.entity.PressupostEntity;

/**
 * Repositori per a gestionar les entitats de tipus Pressupost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomPressupostRepository")
public interface PressupostRepository extends BaseRepository<PressupostEntity, PressupostPk> {
}