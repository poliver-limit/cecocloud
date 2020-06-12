/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.VencimentPagat;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de VencimentPagat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomVencimentPagatController")
@RequestMapping(EcomModuleConfig.API_PATH + "/vencimentsPagat")
public class VencimentPagatApiController extends AbstractIdentificableWithIdentificadorApiController<VencimentPagat> {

}
