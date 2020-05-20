/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.NaturalesaPagamentCobrament;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de Naturaleses de Pagament/Cobrament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomNaturalesaPagamentCobramentController")
@RequestMapping(EcomModuleConfig.API_PATH + "/naturalesesPagamentCobrament")
public class NaturalesaPagamentCobramentApiController extends AbstractIdentificableWithIdentificadorApiController<NaturalesaPagamentCobrament> {

}
