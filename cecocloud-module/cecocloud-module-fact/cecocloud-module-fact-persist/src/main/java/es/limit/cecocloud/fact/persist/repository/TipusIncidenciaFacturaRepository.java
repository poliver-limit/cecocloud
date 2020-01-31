/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.TipusIncidenciaFacturaEntity;

/**
 * Repositori per a gestionar les entitats de tipus TipusIncidenciaFactura.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TipusIncidenciaFacturaRepository extends BaseRepository<TipusIncidenciaFacturaEntity, WithIdentificadorAndCodiPk<String>> {
}