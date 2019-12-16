/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Categoria;
import es.limit.cecocloud.rrhh.persist.entity.CategoriaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Categoria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class CategoriaEntityToDtoConverter extends AbstractEntityToDtoConverter<CategoriaEntity, Categoria> {

}