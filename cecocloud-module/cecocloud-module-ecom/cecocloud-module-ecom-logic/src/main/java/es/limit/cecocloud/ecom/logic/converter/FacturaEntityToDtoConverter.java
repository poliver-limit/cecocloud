/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Factura;
import es.limit.cecocloud.ecom.persist.entity.FacturaEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Factura.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomFacturaEntityToDtoConverter")
public class FacturaEntityToDtoConverter extends AbstractEntityToDtoConverter<FacturaEntity, Factura> {

}