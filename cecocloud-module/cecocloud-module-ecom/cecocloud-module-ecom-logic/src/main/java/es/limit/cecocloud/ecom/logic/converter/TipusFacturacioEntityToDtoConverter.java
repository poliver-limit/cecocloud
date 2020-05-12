/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.TipusFacturacio;
import es.limit.cecocloud.ecom.persist.entity.TipusFacturacioEntity;

/**
 * Conversor cap a DTO de les entitats de tipus TipusFacturacio.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomTipusFacturacioEntityToDtoConverter")
public class TipusFacturacioEntityToDtoConverter extends AbstractEntityToDtoConverter<TipusFacturacioEntity, TipusFacturacio> {

}