/**
 * 
 */
package es.limit.cecocloud.facturacio.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.facturacio.logic.api.dto.TipusVenciment.TipusVencimentPk;
import es.limit.cecocloud.facturacio.persist.entity.TipusVencimentEntity;

/**
 * Repositori per a gestionar les entitats de tipus tipus de venciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface TipusVencimentRepository extends BaseRepository<TipusVencimentEntity, TipusVencimentPk> {
}