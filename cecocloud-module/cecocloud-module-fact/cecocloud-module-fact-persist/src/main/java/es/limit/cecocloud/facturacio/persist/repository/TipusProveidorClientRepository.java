/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.IdentificableWithIdentificadorAndCodi.WithIdentificadorAndCodiPk;
import es.limit.cecocloud.facturacio.persist.entity.TipusProveidorClientEntity;

/**
 * Repositori per a gestionar les entitats de tipus TipusProveidorClient.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TipusProveidorClientRepository extends BaseRepository<TipusProveidorClientEntity, WithIdentificadorAndCodiPk<String>> {
}