/**
 * 
 */
package es.limit.cecocloud.rrhh.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.rrhh.logic.api.dto.Subcategoria;
import es.limit.cecocloud.rrhh.persist.entity.SubcategoriaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Subcategoria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class SubcategoriaEntityToDtoConverter extends AbstractEntityToDtoConverter<SubcategoriaEntity, Subcategoria> {

}