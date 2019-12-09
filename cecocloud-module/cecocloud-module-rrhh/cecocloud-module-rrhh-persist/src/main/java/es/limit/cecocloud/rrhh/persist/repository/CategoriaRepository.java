/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.Categoria.CategoriaPk;
import es.limit.cecocloud.rrhh.persist.entity.CategoriaEntity;

/**
 * Repositori per a gestionar les entitats de tipus Categoria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface CategoriaRepository extends BaseRepository<CategoriaEntity, CategoriaPk> {
}