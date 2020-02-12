/**
 * 
 */
package es.limit.cecocloud.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.logic.api.dto.Recurs;
import es.limit.cecocloud.persist.entity.RecursEntity;

/**
 * Conversor cap a DTO de les entitats de tipus recurs.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class RecursEntityToDtoConverter extends AbstractEntityToDtoConverter<RecursEntity, Recurs> {

}