/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.cecocloud.ecom.logic.api.dto.PaisNif;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de PaisNif.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomPaisNifApicontroller")
@RequestMapping(EcomModuleConfig.API_PATH + "/paisosNif")
public class PaisNifApiController extends AbstractIdentificableApiController<PaisNif,String> {

}
