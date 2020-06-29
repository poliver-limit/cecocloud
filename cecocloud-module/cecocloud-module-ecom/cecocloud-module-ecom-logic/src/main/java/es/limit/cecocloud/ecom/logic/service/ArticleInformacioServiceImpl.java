/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleInformacio;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleInformacio.ArticleInformacioPk;
import es.limit.cecocloud.ecom.logic.api.service.ArticleInformacioService;
import es.limit.cecocloud.ecom.persist.entity.ArticleInformacioEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de registres comercials.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service
public class ArticleInformacioServiceImpl extends AbstractGenericCompositePkServiceImpl<ArticleInformacio, ArticleInformacioEntity, ArticleInformacioPk> implements ArticleInformacioService {

	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Override
	protected ArticleInformacioPk getPkFromDto(ArticleInformacio dto) {			
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new ArticleInformacioPk(
//				dto.getIdentificador().getId(),
				identificador.getEmbedded().getCodi(),		
				dto.getArticle().getPk().getCodi(),				
				dto.getReferenciaSequencial());
	}

}
