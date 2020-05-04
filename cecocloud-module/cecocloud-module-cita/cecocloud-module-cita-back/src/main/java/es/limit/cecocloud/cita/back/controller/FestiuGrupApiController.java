package es.limit.cecocloud.cita.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.base.boot.logic.api.controller.GenericController;
import es.limit.cecocloud.cita.logic.api.dto.FestiuGrup;
import es.limit.cecocloud.fact.back.controller.AbstractIdentificableWithIdentificadorApiController;

/**
 * Controlador per al servei REST de gestió de recursos de tipus grup de festius.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(GenericController.API_PATH + "/festiuGrups")
public class FestiuGrupApiController extends AbstractIdentificableWithIdentificadorApiController<FestiuGrup> {

}
