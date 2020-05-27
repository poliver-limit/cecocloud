/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.PuntVenda.PuntVendaPk;
import es.limit.cecocloud.ecom.persist.entity.PuntVendaEntity;

/**
 * Repositori per a gestionar les entitats de tipus PuntVenda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomPuntVendaRepository")
public interface PuntVendaRepository extends BaseRepository<PuntVendaEntity, PuntVendaPk> {
}