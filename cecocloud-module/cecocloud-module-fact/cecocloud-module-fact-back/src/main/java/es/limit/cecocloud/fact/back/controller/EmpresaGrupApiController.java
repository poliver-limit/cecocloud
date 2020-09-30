/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.EmpresaGrup;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de empreses del grup.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factEmpresaGrupController")
@RequestMapping(FactModuleConfig.API_PATH + "/empresesGrup")
public class EmpresaGrupApiController extends AbstractIdentificableWithIdentificadorApiController<EmpresaGrup> {

}
