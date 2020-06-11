/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.FacturaBase;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de FacturaBase.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomFacturaBaseController")
@RequestMapping(EcomModuleConfig.API_PATH + "/facturesBase")
public class FacturaBaseApiController extends AbstractIdentificableWithIdentificadorApiController<FacturaBase> {

}
