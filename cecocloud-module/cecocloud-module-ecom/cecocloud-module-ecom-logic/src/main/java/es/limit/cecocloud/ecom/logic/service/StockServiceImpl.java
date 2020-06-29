/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.Stock;
import es.limit.cecocloud.ecom.logic.api.dto.Stock.StockPk;
import es.limit.cecocloud.ecom.logic.api.service.StockService;
import es.limit.cecocloud.ecom.persist.entity.StockEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de articles familia empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomStockService")
public class StockServiceImpl extends AbstractGenericCompositePkServiceImpl<Stock, StockEntity, StockPk> implements StockService {
	
	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Override
	protected StockPk getPkFromDto(Stock dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new StockPk(
//				dto.getIdentificador().getId(),		
				identificador.getEmbedded().getCodi(),		
				dto.getMagatzem().getPk().getCodi(),
				dto.getMagatzemPeriode().getPk().getCodi(),
				dto.getArticle().getPk().getCodi(),
				dto.getSTO_TIP());
	}

}
