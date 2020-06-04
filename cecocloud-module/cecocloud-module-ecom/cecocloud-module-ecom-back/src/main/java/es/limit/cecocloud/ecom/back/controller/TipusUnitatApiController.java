/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.TipusUnitat;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de articlesMarca.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomTipusUnitatController")
@RequestMapping(EcomModuleConfig.API_PATH + "/tipusUnitats")
public class TipusUnitatApiController extends AbstractIdentificableWithIdentificadorApiController<TipusUnitat> {

}
