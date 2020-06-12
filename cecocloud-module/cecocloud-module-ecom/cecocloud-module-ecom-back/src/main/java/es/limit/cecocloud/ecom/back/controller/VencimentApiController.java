/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Venciment;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de Venciment.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomVencimentController")
@RequestMapping(EcomModuleConfig.API_PATH + "/venciments")
public class VencimentApiController extends AbstractIdentificableWithIdentificadorApiController<Venciment> {

}
