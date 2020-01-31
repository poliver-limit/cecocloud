/**
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.cecocloud.rrhh.logic.api.dto.Identificador;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModuleConfig;

/**
 * Controlador per al servei REST de gestió de la entitat Identificador.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("IdentificadorRrhhController")
@RequestMapping(RrhhModuleConfig.API_PATH + "/identificadors")
public class IdentificadorApiController extends AbstractIdentificableApiController<Identificador, String> {

}
