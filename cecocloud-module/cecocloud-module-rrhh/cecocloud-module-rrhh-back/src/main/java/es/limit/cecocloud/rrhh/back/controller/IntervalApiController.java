/**
 * 
 */
package es.limit.cecocloud.rrhh.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.rrhh.logic.api.dto.Interval;
import es.limit.cecocloud.rrhh.logic.api.module.RrhhModuleConfig;

/**
 * Controlador per al servei REST de gestió de la entitat Interval.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(RrhhModuleConfig.API_PATH + "/intervals")
public class IntervalApiController extends AbstractIdentificableAmbIdentificadorApiController<Interval> {
}
