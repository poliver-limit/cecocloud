/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Caixa;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de Caixa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomCaixaController")
@RequestMapping(EcomModuleConfig.API_PATH + "/caixes")
public class CaixaApiController extends AbstractIdentificableWithIdentificadorApiController<Caixa> {

}
