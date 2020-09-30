/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.EmpresaGrupEmpreses;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de empreses del grup de empreses.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factEmpresaGrupEmpresesController")
@RequestMapping(FactModuleConfig.API_PATH + "/empresesGrupEmpreses")
public class EmpresaGrupEmpresesApiController extends AbstractIdentificableWithIdentificadorApiController<EmpresaGrupEmpreses> {

}
