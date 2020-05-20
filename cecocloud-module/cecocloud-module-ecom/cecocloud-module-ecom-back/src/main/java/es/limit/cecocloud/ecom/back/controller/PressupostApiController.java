/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Pressupost;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de Pressupost.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomPressupostController")
@RequestMapping(EcomModuleConfig.API_PATH + "/pressupostos")
public class PressupostApiController extends AbstractIdentificableWithIdentificadorApiController<Pressupost> {

}
