/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.CaixaMoviment.CaixaMovimentPk;
import es.limit.cecocloud.ecom.persist.entity.CaixaMovimentEntity;

/**
 * Repositori per a gestionar les entitats de tipus CaixaMoviment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomCaixaMovimentRepository")
public interface CaixaMovimentRepository extends BaseRepository<CaixaMovimentEntity, CaixaMovimentPk> {
}