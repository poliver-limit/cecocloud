/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.VencimentPagat.VencimentPagatPk;
import es.limit.cecocloud.ecom.persist.entity.VencimentPagatEntity;

/**
 * Repositori per a gestionar les entitats de tipus VencimentPagat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomVencimentPagatRepository")
public interface VencimentPagatRepository extends BaseRepository<VencimentPagatEntity, VencimentPagatPk> {
}