/**
 * 
 */
package es.limit.cecocloud.facturacio.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.facturacio.logic.api.dto.ProjecteTipus;
import es.limit.cecocloud.facturacio.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de ProjecteTipus.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(FactModuleConfig.API_PATH + "/projectesTipus")
public class ProjecteTipusApiController extends AbstractIdentificableWithIdentificadorApiController<ProjecteTipus> {

}