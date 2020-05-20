/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Departament;
import es.limit.cecocloud.ecom.persist.entity.DepartamentEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Departament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomDepartamentEntityToDtoConverter")
public class DepartamentEntityToDtoConverter extends AbstractEntityToDtoConverter<DepartamentEntity, Departament> {

}