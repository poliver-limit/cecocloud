/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.TipusAdresa;
import es.limit.cecocloud.ecom.persist.entity.TipusAdresaEntity;

/**
 * Conversor cap a DTO de les entitats de TipusAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomTipusAdresaEntityToDtoConverter")
public class TipusAdresaEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusAdresaEntity, TipusAdresa> {

}
