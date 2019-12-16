/**
 * 
 */
package es.limit.cecocloud.facturacio.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.limit.cecocloud.facturacio.logic.api.dto.MagatzemPeriode;
import es.limit.cecocloud.facturacio.logic.api.module.FacturacioModule;

/**
 * Controlador per al servei REST de gestió de magatzemsPeriode.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@RestController
@RequestMapping(FacturacioModule.API_PATH + "/magatzemsPeriode")
public class MagatzemPeriodeApiController extends AbstractIdentificableAmbIdentificadorApiController<MagatzemPeriode> {

}
