/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.SerieVenda.SerieVendaPk;
import es.limit.cecocloud.ecom.persist.entity.SerieVendaEntity;

/**
 * Repositori per a gestionar les entitats de tipus SerieVenda.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomSerieVendaRepository")
public interface SerieVendaRepository extends BaseRepository<SerieVendaEntity, SerieVendaPk> {
}