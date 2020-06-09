/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.Bestreta.BestretaPk;
import es.limit.cecocloud.ecom.persist.entity.BestretaEntity;

/**
 * Repositori per a gestionar les entitats de tipus Bestreta.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomBestretaRepository")
public interface BestretaRepository extends BaseRepository<BestretaEntity, BestretaPk> {
}