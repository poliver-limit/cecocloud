/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.SerieCompra;
import es.limit.cecocloud.ecom.persist.entity.SerieCompraEntity;

/**
 * Conversor cap a DTO de les entitats de tipus SerieCompra.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomSerieCompraEntityToDtoConverter")
public class SerieCompraEntityToDtoConverter extends AbstractEntityToDtoConverter<SerieCompraEntity, SerieCompra> {

}