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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.logic.api.dto.Identificable;
import es.limit.cecocloud.ecom.logic.api.dto.ArticleModel;
import es.limit.cecocloud.ecom.logic.api.dto.CategoriaTraduccio;
import es.limit.cecocloud.ecom.logic.api.dto.Idioma;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;
import es.limit.cecocloud.ecom.logic.api.service.CategoriaTraduccioService;
import es.limit.cecocloud.ecom.logic.api.service.IdiomaService;
import lombok.extern.slf4j.Slf4j;


/**
 * Controlador per al servei REST de gestió de articlesModel.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Slf4j
@RestController("ecomArticleModelEcommerceController")
@RequestMapping(EcomModuleConfig.API_ECOMMERCE_PATH + "/articlesModel")
public class ArticleModelApiController<D extends Identificable<ID>, ID extends Serializable> extends AbstractIdentificableWithIdentificadorApiController<ArticleModel> {
	
	@Autowired
	CategoriaTraduccioService categoriaTraduccioService;
	
	@Autowired
	IdiomaService idiomaService;
	
	@GetMapping(
			produces = "application/json")
	public ResponseEntity<PagedModel<EntityModel<ArticleModel>>> find(
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
		Page<ArticleModel> pagina = getService().findPageByQuickFilterAndRsqlQuery(
				quickFilter,
				rsqlQuery,
				pageable,
				sort);
		
		// INICI INTERCEPTOR
		List<ArticleModel> articleModelList = pagina.getContent(); 
		int midaLlista = articleModelList.size();
		
		for (int i=0;i<midaLlista;i++) {
			ArticleModel articleModel = articleModelList.get(i);
			articleModel.setDescripcio(this.getTraduccio(articleModel, idiomaCodi));
		}				
		// FINAL INTERCEPTOR
		
		long queryTime = System.currentTimeMillis() - t0;
		log.trace("\ttemps de consulta: " + queryTime + "ms");
		t0 = System.currentTimeMillis();
		ResponseEntity<PagedModel<EntityModel<ArticleModel>>> response = ResponseEntity.ok(
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
	
	private String getTraduccio(ArticleModel articleModel, String codiIdioma) {		

		String traduccio = articleModel.getDescripcio();
		
		if ((!codiIdioma.equals("null"))&&(codiIdioma!=null)) {
			List<Idioma> idiomaList = idiomaService.findByQuickFilterAndRsqlQuery(null,"codiIso=ic='"+codiIdioma+"'",Sort.unsorted());
			Idioma idioma = idiomaList.get(0);
			if (idioma!=null) {
//				CategoriaTraduccio categoriaTraduccio = categoriaTraduccioService.findOneByRsqlQuery("idioma.codiIso=="+idioma.getCodiIso()+";model.codi==" + articleModel.getCodi());
				
				Page<CategoriaTraduccio> categoriaTraduccioPage = categoriaTraduccioService.findPageByQuickFilterAndRsqlQuery(
						null,
						"idioma.codiIso=="+idioma.getCodiIso()+";model.codi==" + articleModel.getCodi(),
						Pageable.unpaged(),
						Sort.unsorted());
				List<CategoriaTraduccio> categoriaTraduccioList = categoriaTraduccioPage.getContent();
				CategoriaTraduccio categoriaTraduccio = null;
				if (categoriaTraduccioList.size()!=0) {
					categoriaTraduccio = categoriaTraduccioList.get(0);
				}
				
				if ((categoriaTraduccio!=null)&&(!categoriaTraduccio.equals(""))) {
					traduccio = categoriaTraduccio.getDescripcio();
				}
			}
		}		
		return traduccio;		
	}

}