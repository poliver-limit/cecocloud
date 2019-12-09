/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.rrhh.logic.api.dto.Categoria;
import es.limit.cecocloud.rrhh.logic.api.dto.Categoria.CategoriaPk;
import es.limit.cecocloud.rrhh.logic.api.service.CategoriaService;
import es.limit.cecocloud.rrhh.persist.entity.CategoriaEntity;

/**
 * Implementació del servei de gestió de categories.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CategoriaServiceImpl extends AbstractGenericCompositePkServiceImpl<Categoria, CategoriaEntity, CategoriaPk> implements CategoriaService {

	@Override
	protected CategoriaPk getPkFromDto(Categoria dto) {
		return new CategoriaPk(
				dto.getIdentificador().getId(),
				dto.getCodi());
	}


}
