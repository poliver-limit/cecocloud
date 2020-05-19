/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.RegimIva;
import es.limit.cecocloud.ecom.persist.entity.RegimIvaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus RegimIva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomRegimIvaEntityToDtoConverter")
public class RegimIvaEntityToDtoConverter extends AbstractEntityToDtoConverter<RegimIvaEntity, RegimIva> {

}