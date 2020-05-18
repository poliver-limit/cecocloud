/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Departament;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de Departament.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomDepartamentController")
@RequestMapping(EcomModuleConfig.API_PATH + "/departaments")
public class DepartamentApiController extends AbstractIdentificableWithIdentificadorApiController<Departament> {

}
