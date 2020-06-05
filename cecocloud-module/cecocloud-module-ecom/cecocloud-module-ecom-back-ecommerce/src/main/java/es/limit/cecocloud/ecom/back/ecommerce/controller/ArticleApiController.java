/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Article;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomArticleEcommerceController")
@RequestMapping(EcomModuleConfig.API_ECOMMERCE_PATH + "/articles")
public class ArticleApiController extends AbstractIdentificableWithIdentificadorApiController<Article> {
	
//	@GetMapping(
//			value = "/search/email/{email}",
//			produces = "application/json")
//	public ResponseEntity<EntityModel<Article>> getByEmail(
//			HttpServletRequest request,
//			@PathVariable final String email) {
//		log.debug("Obtenint usuari per email (email=" + email + ")");
//		try {
//			List<Article> usuari = getService().findPageByQuickFilterAndRsqlQuery("email==\"" + email + "\";actiu==true");
//			if (usuari == null)
//				return ResponseEntity.noContent().build();
//			return ResponseEntity.ok(
//					toResource(usuari, getResourceLinks(usuari.getId())));
//		} catch (NonUniqueResultException ex) {
//			return ResponseEntity.notFound().build();
//		}
//	}

}