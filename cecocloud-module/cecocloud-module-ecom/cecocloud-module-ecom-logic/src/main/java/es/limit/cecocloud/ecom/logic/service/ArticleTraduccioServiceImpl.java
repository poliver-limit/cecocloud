/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleTraduccio;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleTraduccio.ArticleTraduccioPk;
import es.limit.cecocloud.ecom.logic.api.service.ArticleTraduccioService;
import es.limit.cecocloud.ecom.persist.entity.ArticleTraduccioEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;


/**
 * Implementació del servei de gestió de articles traduccio
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomArticleTraduccioService")
public class ArticleTraduccioServiceImpl extends AbstractGenericCompositePkServiceImpl<ArticleTraduccio, ArticleTraduccioEntity, ArticleTraduccioPk> implements ArticleTraduccioService {
	
	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Override
	protected ArticleTraduccioPk getPkFromDto(ArticleTraduccio dto) {	
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new ArticleTraduccioPk(
				identificador.getEmbedded().getCodi(),		
//				dto.getIdentificador().getId(),				
				dto.getArticle().getPk().getCodi(),
				dto.getIdioma().getPk().getCodi());
	}

}
