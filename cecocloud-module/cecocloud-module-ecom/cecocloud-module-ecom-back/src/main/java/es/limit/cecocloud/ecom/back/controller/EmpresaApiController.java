/**
 * 
 */
package es.limit.cecocloud.ecom.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.ecom.logic.api.dto.Empresa;
import es.limit.cecocloud.ecom.logic.api.module.EcomModuleConfig;

/**
 * Controlador per al servei REST de gestió de empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ecomEmpresaApiController")
@RequestMapping(EcomModuleConfig.API_PATH + "/empreses")
public class EmpresaApiController extends AbstractIdentificableWithIdentificadorApiController<Empresa> {

}
