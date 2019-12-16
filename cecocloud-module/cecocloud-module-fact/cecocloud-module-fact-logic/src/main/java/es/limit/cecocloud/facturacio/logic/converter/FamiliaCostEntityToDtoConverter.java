/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.FamiliaCost;
import es.limit.cecocloud.facturacio.persist.entity.FamiliaCostEntity;

/**
 * Conversor cap a DTO de les entitats de tipus FamiliaCost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class FamiliaCostEntityToDtoConverter extends AbstractEntityToDtoConverter<FamiliaCostEntity, FamiliaCost> {

}