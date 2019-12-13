/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.Subcategoria;
import es.limit.cecocloud.rrhh.logic.api.service.SubcategoriaService;
import es.limit.cecocloud.rrhh.persist.entity.SubcategoriaEntity;

/**
 * Implementació del servei de gestió de subcategories.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class SubcategoriaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Subcategoria, SubcategoriaEntity, String> implements SubcategoriaService {

}
