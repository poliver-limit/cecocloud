/**
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.rrhh.logic.api.dto.Zona;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModuleConfig;

/**
 * Controlador per al servei REST de gestió de la entitat Zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ZonaRrhhController")
@RequestMapping(RrhhModuleConfig.API_PATH + "/zones")
public class ZonaApiController extends AbstractIdentificableAmbIdentificadorApiController<Zona> {

}
