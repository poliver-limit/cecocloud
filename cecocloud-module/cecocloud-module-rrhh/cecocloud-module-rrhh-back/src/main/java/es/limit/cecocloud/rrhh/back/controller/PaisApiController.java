/*
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import es.limit.cecocloud.rrhh.logic.api.dto.Pais;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModuleConfig;

/**
 * Controlador per al servei REST de gestió de paisos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */

@RequestMapping(RrhhModuleConfig.API_PATH + "/paisos")
public class PaisApiController extends AbstractIdentificableAmbIdentificadorApiController<Pais> {

}
