/**
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.rrhh.logic.api.dto.Empresa;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModule;

/**
 * Controlador per al servei REST de gestió de la entitat Empresa.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("rrhhEmpresaController")
@RequestMapping(RrhhModule.API_PATH + "/empreses")
public class EmpresaApiController extends AbstractIdentificableAmbIdentificadorApiController<Empresa> {

}
