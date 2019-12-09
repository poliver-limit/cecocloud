/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.Subcategoria;
import es.limit.cecocloud.rrhh.logic.api.dto.Subcategoria.SubcategoriaPk;
import es.limit.cecocloud.rrhh.logic.api.service.SubcategoriaService;
import es.limit.cecocloud.rrhh.persist.entity.SubcategoriaEntity;

/**
 * Implementació del servei de gestió de subcategories.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SubcategoriaServiceImpl extends AbstractGenericCompositePkServiceImpl<Subcategoria, SubcategoriaEntity, SubcategoriaPk> implements SubcategoriaService {

	@Override
	protected SubcategoriaPk getPkFromDto(Subcategoria dto) {
		return new SubcategoriaPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
