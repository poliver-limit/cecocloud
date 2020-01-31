/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Banc;
import es.limit.cecocloud.fact.persist.entity.BancEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Banc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class BancEntityToDtoConverter extends AbstractEntityToDtoConverter<BancEntity, Banc> {

}
