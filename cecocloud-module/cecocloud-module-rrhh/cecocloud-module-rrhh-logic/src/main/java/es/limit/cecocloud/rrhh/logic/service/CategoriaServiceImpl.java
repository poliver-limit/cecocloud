/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.service;

import org.springframework.stereotype.Service;

import es.limit.cecocloud.rrhh.logic.api.dto.Categoria;
import es.limit.cecocloud.rrhh.logic.api.service.CategoriaService;
import es.limit.cecocloud.rrhh.persist.entity.CategoriaEntity;

/**
 * Implementació del servei de gestió de categories.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class CategoriaServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Categoria, CategoriaEntity, String> implements CategoriaService {

}
