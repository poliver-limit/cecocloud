/*
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import es.limit.cecocloud.rrhh.logic.api.dto.CodiPostal;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModuleConfig;

/**
 * Controlador per al servei REST de gestió de codis postal.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@RequestMapping(RrhhModuleConfig.API_PATH + "/codisPostal")
public class CodiPostalApiController extends AbstractIdentificableAmbIdentificadorApiController<CodiPostal> {

}