/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.Departament;
import es.limit.cecocloud.facturacio.persist.entity.DepartamentEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Departament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class DepartamentEntityToDtoConverter extends AbstractEntityToDtoConverter<DepartamentEntity, Departament> {

}