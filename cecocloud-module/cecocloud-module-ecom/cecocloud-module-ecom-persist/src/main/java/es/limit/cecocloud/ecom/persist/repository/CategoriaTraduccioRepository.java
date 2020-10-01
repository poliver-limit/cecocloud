/**
 * 
 */
package es.limit.cecocloud.ecom.persist.repository;

import org.springframework.stereotype.Repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.ecom.logic.api.dto.CategoriaTraduccio.CategoriaTraduccioPk;
import es.limit.cecocloud.ecom.persist.entity.CategoriaTraduccioEntity;

/**
 * Repositori per a gestionar les entitats de tipus CategoriaTraduccio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Repository("ecomCategoriaTraduccioRepository")
public interface CategoriaTraduccioRepository extends BaseRepository<CategoriaTraduccioEntity, CategoriaTraduccioPk> {
}