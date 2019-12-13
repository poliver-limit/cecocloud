/**
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.back.controller.AbstractIdentificableApiController;
import es.limit.cecocloud.rrhh.logic.api.dto.Zona;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModule;

/**
 * Controlador per al servei REST de gestió de la entitat Zona.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ZonaRrhhController")
@RequestMapping(RrhhModule.API_PATH + "/zones")
public class ZonaApiController extends AbstractIdentificableApiController<Zona, String> {

}
