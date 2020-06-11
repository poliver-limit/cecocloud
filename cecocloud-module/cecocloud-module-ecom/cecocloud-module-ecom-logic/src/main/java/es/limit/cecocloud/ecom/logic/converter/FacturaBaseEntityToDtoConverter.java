/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.FacturaBase;
import es.limit.cecocloud.ecom.persist.entity.FacturaBaseEntity;

/**
 * Conversor cap a DTO de les entitats de tipus FacturaBase.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomFacturaBaseEntityToDtoConverter")
public class FacturaBaseEntityToDtoConverter extends AbstractEntityToDtoConverter<FacturaBaseEntity, FacturaBase> {

}