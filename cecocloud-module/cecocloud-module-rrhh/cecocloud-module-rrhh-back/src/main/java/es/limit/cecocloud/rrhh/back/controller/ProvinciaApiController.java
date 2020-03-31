/*
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.rrhh.logic.api.dto.Provincia;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModuleConfig;

/**
 * Controlador per al servei REST de gestió de provincies.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("ProvinciaRrhhController")
@RequestMapping(RrhhModuleConfig.API_PATH + "/provincies")
public class ProvinciaApiController extends AbstractIdentificableAmbIdentificadorApiController<Provincia> {

}
