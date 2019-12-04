/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.UnitatTipus.UnitatTipusPk;
import es.limit.cecocloud.facturacio.persist.entity.UnitatTipusEntity;

/**
 * Repositori per a gestionar les entitats de tipus UnitatTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface UnitatTipusRepository extends BaseRepository<UnitatTipusEntity, UnitatTipusPk> {
}