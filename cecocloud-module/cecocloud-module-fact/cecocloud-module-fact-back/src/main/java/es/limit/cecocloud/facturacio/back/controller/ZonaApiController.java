/**
 * 
 */
package es.limit.cecocloud.facturacio.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.facturacio.logic.api.dto.Zona;
import es.limit.cecocloud.facturacio.logic.api.module.FacturacioModule;

/**
 * Controlador per al servei REST de gestió de zones.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("factZonaApiController")
@RequestMapping(FacturacioModule.API_PATH + "/zones")
public class ZonaApiController extends AbstractIdentificableWithIdentificadorApiController<Zona> {

}
