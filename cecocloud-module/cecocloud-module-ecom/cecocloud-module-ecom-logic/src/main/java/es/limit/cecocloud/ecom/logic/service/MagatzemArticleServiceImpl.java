/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.base.boot.logic.service.AbstractGenericCompositePkServiceImpl;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemArticle;
import es.limit.cecocloud.ecom.logic.api.dto.MagatzemArticle.MagatzemArticlePk;
import es.limit.cecocloud.ecom.logic.api.service.MagatzemArticleService;
import es.limit.cecocloud.ecom.persist.entity.MagatzemArticleEntity;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.persist.entity.IdentificadorEntity;
import es.limit.cecocloud.persist.repository.IdentificadorRepository;

/**
 * Implementació del servei de gestió de articles familia empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomMagatzemArticleService")
public class MagatzemArticleServiceImpl extends AbstractGenericCompositePkServiceImpl<MagatzemArticle, MagatzemArticleEntity, MagatzemArticlePk> implements MagatzemArticleService {
	
	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	private IdentificadorRepository identificadorRepository;
	
	@Override
	protected MagatzemArticlePk getPkFromDto(MagatzemArticle dto) {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		IdentificadorEntity identificador = identificadorRepository.getOne(userSession.getI());
		return new MagatzemArticlePk(
//				dto.getIdentificador().getId(),
				identificador.getEmbedded().getCodi(),		
				dto.getMagatzem().getPk().getCodi(),				
				dto.getArticle().getPk().getCodi());
	}

}
