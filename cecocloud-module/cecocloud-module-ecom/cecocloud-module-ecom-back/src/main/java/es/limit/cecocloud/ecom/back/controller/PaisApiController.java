/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Pais;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de Pais.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomPaisController")
@RequestMapping(EcomModuleConfig.API_PATH + "/paisos")
public class PaisApiController extends AbstractIdentificableWithIdentificadorApiController<Pais> {

}
