/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusFacturacio.TipusFacturacioPk;
import es.limit.cecocloud.facturacio.persist.entity.TipusFacturacioEntity;

/**
 * Repositori per a gestionar les entitats de tipus TipusFacturacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TipusFacturacioRepository extends BaseRepository<TipusFacturacioEntity, TipusFacturacioPk> {
}