package es.limit.cecocloud.cita.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.cita.logic.api.dto.Horari;
import es.limit.cecocloud.cita.logic.api.module.CitaModule;
import es.limit.cecocloud.fact.back.controller.AbstractIdentificableWithIdentificadorApiController;

/**
 * Controlador per al servei REST de gestió de recursos de tipus horari.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController("citaHorariApiController")
@RequestMapping(CitaModule.API_PATH + "/horaris")
public class HorariApiController extends AbstractIdentificableWithIdentificadorApiController<Horari> {

}
