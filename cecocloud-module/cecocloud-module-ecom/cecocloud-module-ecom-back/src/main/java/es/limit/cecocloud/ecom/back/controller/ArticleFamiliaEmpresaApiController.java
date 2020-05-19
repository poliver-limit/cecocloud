/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.ArticleFamiliaEmpresa;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de articlesFamiliaEmpresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomArticleFamiliaEmpresaController")
@RequestMapping(EcomModuleConfig.API_PATH + "/articlesFamiliaEmpresa")
public class ArticleFamiliaEmpresaApiController extends AbstractIdentificableWithIdentificadorApiController<ArticleFamiliaEmpresa> {

}
