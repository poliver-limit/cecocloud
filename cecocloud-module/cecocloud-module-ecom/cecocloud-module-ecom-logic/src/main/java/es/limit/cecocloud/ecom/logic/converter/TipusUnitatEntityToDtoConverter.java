/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.TipusUnitat;
import es.limit.cecocloud.ecom.persist.entity.TipusUnitatEntity;

/**
 * Conversor cap a DTO de les entitats de tipus TipusUnitat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomTipusUnitatEntityToDtoConverter")
public class TipusUnitatEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusUnitatEntity, TipusUnitat> {

}