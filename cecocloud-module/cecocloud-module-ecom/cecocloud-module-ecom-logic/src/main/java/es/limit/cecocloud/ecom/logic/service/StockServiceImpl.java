/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.stereotype.Service;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.Stock;
import es.limit.cecocloud.ecom.logic.api.dto.Stock.StockPk;
import es.limit.cecocloud.ecom.logic.api.service.StockService;
import es.limit.cecocloud.ecom.persist.entity.StockEntity;

/**
 * Implementació del servei de gestió de articles familia empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomStockService")
public class StockServiceImpl extends AbstractGenericCompositePkServiceImpl<Stock, StockEntity, StockPk> implements StockService {
	
	@Override
	protected StockPk getPkFromDto(Stock dto) {
		return new StockPk(
				dto.getIdentificador().getId(),				
				dto.getMagatzem().getPk().getCodi(),
				dto.getMagatzemPeriode().getPk().getCodi(),
				dto.getArticle().getPk().getCodi(),
				dto.getSTO_TIP());
	}

}
