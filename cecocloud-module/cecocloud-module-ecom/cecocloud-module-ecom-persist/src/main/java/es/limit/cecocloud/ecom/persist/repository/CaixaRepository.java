/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.Caixa.CaixaPk;
import es.limit.cecocloud.ecom.persist.entity.CaixaEntity;

/**
 * Repositori per a gestionar les entitats de tipus Caixa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomCaixaRepository")
public interface CaixaRepository extends BaseRepository<CaixaEntity, CaixaPk> {
}