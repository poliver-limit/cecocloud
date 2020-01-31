/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.Empresa;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factEmpresaApiController")
@RequestMapping(FactModuleConfig.API_PATH + "/empreses")
public class EmpresaApiController extends AbstractIdentificableWithIdentificadorApiController<Empresa> {

}
