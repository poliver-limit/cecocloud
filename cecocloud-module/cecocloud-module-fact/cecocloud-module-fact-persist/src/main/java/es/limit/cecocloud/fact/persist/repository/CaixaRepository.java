/**
 * 
 */
package es.limit.cecocloud.fact.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.fact.logic.api.dto.Caixa.CaixaPk;
import es.limit.cecocloud.fact.persist.entity.CaixaEntity;

/**
 * Repositori per a gestionar les entitats de tipus caixa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface CaixaRepository extends BaseRepository<CaixaEntity, CaixaPk> {
}