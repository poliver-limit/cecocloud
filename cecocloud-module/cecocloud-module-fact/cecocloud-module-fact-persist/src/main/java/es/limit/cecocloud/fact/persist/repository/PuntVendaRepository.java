/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.PuntVenda.PuntVendaPk;
import es.limit.cecocloud.fact.persist.entity.PuntVendaEntity;

/**
 * Repositori per a gestionar les entitats de tipus punt de venda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("factPuntVendaRepository")
public interface PuntVendaRepository extends BaseRepository<PuntVendaEntity, PuntVendaPk> {
}