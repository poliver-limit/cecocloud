/**
 * 
 */
package es.limit.cecocloud.facturacio.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.facturacio.logic.api.dto.RegimIva;
import es.limit.cecocloud.facturacio.persist.entity.RegimIvaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus RegimIva.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component
public class RegimIvaEntityToDtoConverter extends AbstractEntityToDtoConverter<RegimIvaEntity, RegimIva> {

}