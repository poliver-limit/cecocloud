/**
 * 
 */
package es.limit.cecocloud.rrhh.persist.repository;

import es.limit.base.boot.persist.repository.BaseRepository;
import es.limit.cecocloud.rrhh.logic.api.dto.Subcategoria.SubcategoriaPk;
import es.limit.cecocloud.rrhh.persist.entity.SubcategoriaEntity;

/**
 * Repositori per a gestionar les entitats de tipus Subcategoria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface SubcategoriaRepository extends BaseRepository<SubcategoriaEntity, SubcategoriaPk> {
}