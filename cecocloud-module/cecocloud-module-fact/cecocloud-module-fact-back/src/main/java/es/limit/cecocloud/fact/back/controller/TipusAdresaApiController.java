/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.cecocloud.fact.logic.api.dto.TipusAdresa;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de TipusAdresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factTipusAdresaApicontroller")
@RequestMapping(FactModuleConfig.API_PATH + "/tipusAdreces")
/*public class TipusAdresaApiController extends AbstractIdentificableWithIdentificadorApiController<TipusAdresa> {

}*/
public class TipusAdresaApiController extends AbstractIdentificableApiController<TipusAdresa,String> {

}


