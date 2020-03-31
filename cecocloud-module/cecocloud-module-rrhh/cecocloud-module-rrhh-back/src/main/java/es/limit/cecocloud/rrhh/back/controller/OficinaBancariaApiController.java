/**
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.rrhh.logic.api.dto.OficinaBancaria;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModuleConfig;

/**
 * Controlador per al servei REST de gestió de OficinaBancaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("OficinaBancariaRrhhController")
@RequestMapping(RrhhModuleConfig.API_PATH + "/oficinesBancaries")
public class OficinaBancariaApiController extends AbstractIdentificableAmbIdentificadorApiController<OficinaBancaria> {

}

