/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Idioma;
import es.limit.cecocloud.ecom.persist.entity.IdiomaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Idioma.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomIdiomaEntityToDtoConverter")
public class IdiomaEntityToDtoConverter extends AbstractEntityToDtoConverter<IdiomaEntity, Idioma> {

}