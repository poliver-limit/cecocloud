/*
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import es.limit.cecocloud.rrhh.logic.api.dto.Banc;

import es.limit.cecocloud.rrhh.logic.api.module.RrhhModuleConfig;

/**
 * Controlador per al servei REST de gestió de Banc.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@RequestMapping(RrhhModuleConfig.API_PATH + "/bancs")
public class BancApiController extends AbstractIdentificableAmbIdentificadorApiController<Banc> {

}
