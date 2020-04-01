/**
 * 
 */
package es.limit.cecocloud.fact.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.fact.logic.api.dto.ProjectePressupost;
import es.limit.cecocloud.fact.logic.api.module.FactModuleConfig;

/**
 * Controlador per al servei REST de gestió de projectes - pressupostos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(FactModuleConfig.API_PATH + "/projectesPressupost")
public class ProjectePressupostApiController extends AbstractIdentificableWithIdentificadorApiController<ProjectePressupost> {

}
