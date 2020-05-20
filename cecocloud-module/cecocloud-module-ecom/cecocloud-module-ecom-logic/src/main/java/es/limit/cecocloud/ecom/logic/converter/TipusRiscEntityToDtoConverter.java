/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.TipusRisc;
import es.limit.cecocloud.ecom.persist.entity.TipusRiscEntity;

/**
 * Conversor cap a DTO de les entitats de tipus TipusRisc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomTipusRiscEntityToDtoConverter")
public class TipusRiscEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusRiscEntity, TipusRisc> {

}