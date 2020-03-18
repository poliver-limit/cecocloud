/**
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import es.limit.cecocloud.rrhh.logic.api.dto.OficinaBancaria;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModuleConfig;

/**
 * Controlador per al servei REST de gestió de OficinaBancaria.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RequestMapping(RrhhModuleConfig.API_PATH + "/oficinesBancaries")
public class OficinaBancariaApiController extends AbstractIdentificableAmbIdentificadorApiController<OficinaBancaria> {

}

