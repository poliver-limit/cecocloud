/**
 * 
 */
package es.limit.cecocloud.fact.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.fact.logic.api.dto.FamiliaCost;
import es.limit.cecocloud.fact.persist.entity.FamiliaCostEntity;

/**
 * Conversor cap a DTO de les entitats de tipus FamiliaCost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class FamiliaCostEntityToDtoConverter extends AbstractEntityToDtoConverter<FamiliaCostEntity, FamiliaCost> {

}