/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.fact.persist.entity.SerieVendaEntity;

/**
 * Repositori per a gestionar les entitats de tipus SerieVenda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SerieVendaRepository extends BaseRepository<SerieVendaEntity, SerieVendaPk> {
}