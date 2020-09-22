/**
 * 
 */
package es.limit.cecocloud.ecom.logic.api.service;

import java.util.List;

import es.limit.base.boot.logic.api.service.GenericCompositePkService;
import es.limit.cecocloud.ecom.logic.api.dto.Article;

/**
 * Servei per a la gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public interface ArticleService extends GenericCompositePkService<Article> {
	
	public List<Article> getArticlesActius();
	
	public Article getArticle();

}
