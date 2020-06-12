/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.Venciment.VencimentPk;
import es.limit.cecocloud.ecom.persist.entity.VencimentEntity;

/**
 * Repositori per a gestionar les entitats de tipus Venciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomVencimentRepository")
public interface VencimentRepository extends BaseRepository<VencimentEntity, VencimentPk> {
}