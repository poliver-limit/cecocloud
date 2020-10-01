/**
 * 
 */
package es.limit.cecocloud.ecom.back.ecommerce.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.cecocloud.ecom.logic.api.dto.Article;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleTraduccio;
import es.limit.cecocloud.ecom.logic.api.dto.Idioma;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;
import es.limit.cecocloud.ecom.logic.api.service.ArticleService;
import es.limit.cecocloud.ecom.logic.api.service.ArticleTraduccioService;
import es.limit.cecocloud.ecom.logic.api.service.IdiomaService;
import lombok.extern.slf4j.Slf4j;


/**
 * Controlador per al servei REST de gestió de articles.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController("ecomArticleEcommerceController")
@RequestMapping(EcomModuleConfig.API_ECOMMERCE_PATH + "/articles")
public class ArticleApiController<D extends Identificable<ID>, ID extends Serializable> extends AbstractIdentificableWithIdentificadorApiController<Article> {
	
	@Autowired
	ArticleTraduccioService articleTraduccioService;
	
	@Autowired
	IdiomaService idiomaService;
	
	@GetMapping(
			produces = "application/json")
	public ResponseEntity<PagedModel<EntityModel<Article>>> find(
			HttpServletRequest request,
			@RequestParam(value = "namedFilter", required = false) final String[] namedFilters,
			@RequestParam(value = "quickFilter", required = false) final String quickFilter,
			@RequestParam(value = "query", required = false) final String query,
			@RequestParam(value = "lang", required = false) final String idiomaCodi,
			final Pageable pageable,
			final Sort sort) {
		log.debug("Consultant entitats amb filtre i paginació (" +
				"namedFilter=" + namedFilters + "," +
				"quickFilter=" + quickFilter + "," +
				"query=" + query + "," +
				"pageable=" + pageable + "," +
				"sort=" + sort + ")");
		long t0 = System.currentTimeMillis();
		long initialTime = t0;
		String rsqlQuery = buildServiceRsqlQuery(
				request,
				query,
				namedFilters);
		log.debug("\tconsulta RSQL final: " + rsqlQuery);
		long queryBuildTime = System.currentTimeMillis() - t0;
		log.trace("\ttemps de càlcul de la consulta RSQL: " + queryBuildTime + "ms");
		t0 = System.currentTimeMillis();
		Page<Article> pagina = getService().findPageByQuickFilterAndRsqlQuery(
				quickFilter,
				rsqlQuery,
				pageable,
				sort);
		
		// INICI INTERCEPTOR
		List<Article> articleList = pagina.getContent(); 
		int midaLlista = articleList.size();
		
		for (int i=0;i<midaLlista;i++) {
			Article article = articleList.get(i);
			article.setDescripcioCurta(this.getTraducció(article, idiomaCodi));
		}				
		// FINAL INTERCEPTOR
		
		long queryTime = System.currentTimeMillis() - t0;
		log.trace("\ttemps de consulta: " + queryTime + "ms");
		t0 = System.currentTimeMillis();
		ResponseEntity<PagedModel<EntityModel<Article>>> response = ResponseEntity.ok(
				toPagedResources(
						pagina,
						getClass(),
						getDefaultResourceLinksBuilder()));
		long conversionTime = System.currentTimeMillis() - t0;
		log.trace("\\ttemps de conversió dels resultats: " + conversionTime + "ms");
		long totalTime = System.currentTimeMillis() - initialTime;
		log.trace("\\ttemps total:" + totalTime + "ms");
		return response;
	}
	
	@GetMapping(value = "/detail/{articleId}",
			produces = "application/json")
	public ResponseEntity<EntityModel<Article>> article(
			HttpServletRequest request,
			@RequestParam(value = "lang", required = false) final String idiomaCodi,
			@PathVariable String articleId
			) {
		Article article =((ArticleService)getService()).getOne(articleId);				
		article.setDescripcioCurta(this.getTraducció(article, idiomaCodi));
		return ResponseEntity.ok(
				toResource(article, getResourceLinks(article.getId())));
	}
	
	private String getTraducció(Article article, String codiIdioma) {		

		String traduccio = article.getDescripcioCurta();
		if (traduccio==null||traduccio.equals("")) {
			traduccio = article.getDescripcio();
		}
		if ((!codiIdioma.equals("null"))&&(codiIdioma!=null)) {
			List<Idioma> idiomaList = idiomaService.findByQuickFilterAndRsqlQuery(null,"codiIso=ic='"+codiIdioma+"'",Sort.unsorted());
			Idioma idioma = idiomaList.get(0);
//			Idioma idioma = idiomaService.findOneByRsqlQuery("codiIso=ic='"+codiIdioma+"'");		
			if (idioma!=null) {
				ArticleTraduccio articleTraduccio = articleTraduccioService.findOneByRsqlQuery("idioma.codi=="+idioma.getCodi()+";article.codi==" + article.getCodi());
				if ((articleTraduccio!=null)&&(!articleTraduccio.equals(""))) {
					traduccio = articleTraduccio.getDescripcio();
				}
			}
		}		
		return traduccio;
		
	}
	
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