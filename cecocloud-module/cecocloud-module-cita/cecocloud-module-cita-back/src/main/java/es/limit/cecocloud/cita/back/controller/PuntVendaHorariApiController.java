package es.limit.cecocloud.cita.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.cita.logic.api.dto.PuntVendaHorari;
import es.limit.cecocloud.cita.logic.api.module.CitaModule;
import es.limit.cecocloud.fact.back.controller.AbstractIdentificableWithIdentificadorApiController;

/**
 * Controlador per al servei REST de gestió de relacions entre punts de venda
 * i horaris.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(CitaModule.API_PATH + "/puntVendaHoraris")
public class PuntVendaHorariApiController extends AbstractIdentificableWithIdentificadorApiController<PuntVendaHorari> {

}
