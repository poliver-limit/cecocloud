/**
 * 
 */
package es.limit.cecocloud.ecom.logic.converter;

import org.springframework.stereotype.Component;

import es.limit.base.boot.logic.converter.AbstractEntityToDtoConverter;
import es.limit.cecocloud.ecom.logic.api.dto.Stock;
import es.limit.cecocloud.ecom.persist.entity.StockEntity;

/**
 * Conversor cap a DTO de les entitats de tipus Stock.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Component("ecomStockEntityToDtoConverter")
public class StockEntityToDtoConverter extends AbstractEntityToDtoConverter<StockEntity, Stock> {

}