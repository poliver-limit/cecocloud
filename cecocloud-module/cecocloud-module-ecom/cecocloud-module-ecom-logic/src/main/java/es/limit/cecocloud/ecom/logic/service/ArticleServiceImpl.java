/**
 * 
 */
package es.limit.cecocloud.ecom.logic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.limit.base.boot.logic.helper.AuthenticationHelper;
import es.limit.cecocloud.ecom.logic.api.dto.Article;
import es.limit.cecocloud.ecom.logic.api.service.ArticleService;
import es.limit.cecocloud.ecom.persist.entity.ArticleEntity;
import es.limit.cecocloud.ecom.persist.repository.ArticleRepository;
import es.limit.cecocloud.logic.api.dto.Identificador;
import es.limit.cecocloud.logic.api.dto.UserSession;
import es.limit.cecocloud.logic.api.service.IdentificadorService;

/**
 * Implementació del servei de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Service("ecomArticleService")
public class ArticleServiceImpl extends AbstractAmbIdentificadorICodiServiceImpl<Article, ArticleEntity, String> implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private AuthenticationHelper authenticationHelper;
	
	@Autowired
	protected IdentificadorService identificadorService;
	
	public List<Article> getArticlesActius() {
		UserSession userSession = (UserSession)authenticationHelper.getSession();
		
		Identificador identificador = identificadorService.getOne(((UserSession)userSession).getI());
		List<ArticleEntity> articleEntityList = articleRepository.findByIdentificador(identificador.getCodi());
		return conversionHelper.toDto(
				articleEntityList,
				ArticleEntity.class,
				Article.class);
	}
	
	public Article getArticle() {
		
		ArticleEntity articleEntity = null;
		return conversionHelper.toDto(
				articleEntity,
				ArticleEntity.class,
				Article.class);
	}
}
