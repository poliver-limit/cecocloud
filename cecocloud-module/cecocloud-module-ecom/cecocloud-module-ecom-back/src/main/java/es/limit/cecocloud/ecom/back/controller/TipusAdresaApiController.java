/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.cecocloud.ecom.logic.api.dto.TipusAdresa;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de TipusAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomTipusAdresaApicontroller")
@RequestMapping(EcomModuleConfig.API_PATH + "/tipusAdreces")
/*public class TipusAdresaApiController extends AbstractIdentificableWithIdentificadorApiController<TipusAdresa> {

}*/
public class TipusAdresaApiController extends AbstractIdentificableApiController<TipusAdresa,String> {

}

