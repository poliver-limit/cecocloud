/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.ArticleFamilia;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de articlesFamilia.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomArticleFamiliaController")
@RequestMapping(EcomModuleConfig.API_PATH + "/articlesFamilia")
public class ArticleFamiliaApiController extends AbstractIdentificableWithIdentificadorApiController<ArticleFamilia> {

}
