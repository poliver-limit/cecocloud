package es.limit.cecocloud.cita.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.cita.logic.api.dto.Festiu;
import es.limit.cecocloud.fact.back.controller.AbstractIdentificableWithIdentificadorApiController;

/**
 * Controlador per al servei REST de gestió de recursos de tipus festiu.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/festius")
public class FestiuApiController extends AbstractIdentificableWithIdentificadorApiController<Festiu> {

}
