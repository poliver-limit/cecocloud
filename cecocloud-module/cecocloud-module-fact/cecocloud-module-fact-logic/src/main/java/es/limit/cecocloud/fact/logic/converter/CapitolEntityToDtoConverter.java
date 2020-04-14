/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.Capitol;
import es.limit.cecocloud.fact.persist.entity.CapitolEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Capitol.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class CapitolEntityToDtoConverter extends AbstractEntityToDtoConverter<CapitolEntity, Capitol> {

}