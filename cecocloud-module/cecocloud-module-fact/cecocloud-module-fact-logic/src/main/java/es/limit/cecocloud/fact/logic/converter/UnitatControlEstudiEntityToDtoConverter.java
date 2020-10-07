/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.UnitatControlEstudi;
import es.limit.cecocloud.fact.persist.entity.UnitatControlEstudiEntity;

/**
 * Conversor cap a DTO de les entitats de tipus UnitatControlEstudi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("factUnitatControlEstudiEntityToDtoConverter")
public class UnitatControlEstudiEntityToDtoConverter extends AbstractEntityToDtoConverter<UnitatControlEstudiEntity, UnitatControlEstudi> {

}