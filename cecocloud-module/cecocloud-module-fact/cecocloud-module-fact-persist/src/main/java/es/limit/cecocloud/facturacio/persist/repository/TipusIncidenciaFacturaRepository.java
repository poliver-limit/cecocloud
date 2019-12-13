/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.persist.entity.TipusIncidenciaFacturaEntity;

/**
 * Repositori per a gestionar les entitats de tipus TipusIncidenciaFactura.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TipusIncidenciaFacturaRepository extends BaseRepository<TipusIncidenciaFacturaEntity, AmbIdentificadorICodiPk<String>> {
}