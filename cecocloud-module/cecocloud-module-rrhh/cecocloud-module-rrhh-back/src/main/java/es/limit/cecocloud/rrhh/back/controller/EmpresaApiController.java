/**
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.rrhh.logic.api.dto.Empresa;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModuleConfig;

/**
 * Controlador per al servei REST de gestió de la entitat Empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("rrhhEmpresaController")
@RequestMapping(RrhhModuleConfig.API_PATH + "/empresesRrhh")
public class EmpresaApiController extends AbstractIdentificableAmbIdentificadorApiController<Empresa> {

}
