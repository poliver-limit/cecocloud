/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.fact.persist.entity.DocumentPagamentCobramentEntity;

/**
 * Repositori per a gestionar les entitats de tipus document de pagament/cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface DocumentPagamentCobramentRepository extends BaseRepository<DocumentPagamentCobramentEntity, WithIdentificadorAndCodiPk<String>> {
}