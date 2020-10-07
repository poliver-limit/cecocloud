/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.LiniaEstudi;
import es.limit.cecocloud.fact.persist.entity.LiniaEstudiEntity;

/**
 * Conversor cap a DTO de les entitats de tipus LiniaEstudi.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("factLiniaEstudiEntityToDtoConverter")
public class LiniaEstudiEntityToDtoConverter extends AbstractEntityToDtoConverter<LiniaEstudiEntity, LiniaEstudi> {

}