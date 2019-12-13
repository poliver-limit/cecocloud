/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.AbstractIdentificableAmbIdentificador.AmbIdentificadorICodiPk;
import es.limit.cecocloud.facturacio.persist.entity.DocumentPagamentCobramentEntity;

/**
 * Repositori per a gestionar les entitats de tipus document de pagament/cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface DocumentPagamentCobramentRepository extends BaseRepository<DocumentPagamentCobramentEntity, AmbIdentificadorICodiPk<String>> {
}